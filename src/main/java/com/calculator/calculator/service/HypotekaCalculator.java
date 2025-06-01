import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
 
public class HypotekaCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(HypotekaGUI::new);
    }
}
 
class HypotekaGUI {
    private final JFrame frame;
    private final JTextField amountField, yearsField, fixationsField, feeField;
    private final JTextArea resultArea;
 
    public HypotekaGUI() {
        frame = new JFrame("Hypoteční kalkulačka");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null); // zarovnat doprostřed
 
        var panel = new JPanel(new GridLayout(6, 2, 5, 5));
 
        panel.add(new JLabel("Výše hypotéky (Kč):"));
        amountField = new JTextField();
        panel.add(amountField);
 
        panel.add(new JLabel("Doba splácení (let):"));
        yearsField = new JTextField();
        panel.add(yearsField);
 
        panel.add(new JLabel("Doba fixace sazby:"));
        fixationsField = new JTextField();
        panel.add(fixationsField);
 
        panel.add(new JLabel("Poplatek (Kč):"));
        feeField = new JTextField();
        panel.add(feeField);
 
        var calculateButton = new JButton("Vypočítat");
        panel.add(calculateButton);
 
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        resultArea.setMargin(new Insets(5, 5, 5, 5));
 
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);
 
        calculateButton.addActionListener(this::calculateMortgage);
 
        frame.setVisible(true);
    }
 
    private void calculateMortgage(ActionEvent e) {
        try {
            var loanAmount = Double.parseDouble(amountField.getText());
            var years = Integer.parseInt(yearsField.getText());
            var fixations = Integer.parseInt(fixationsField.getText()); // nevyužito
            var fee = Double.parseDouble(feeField.getText());
 
            var annualRate = 0.05; // pevná roční úroková sazba 5 %
            var monthlyRate = annualRate / 12;
            var months = years * 12;
 
            var monthlyPayment = (loanAmount * monthlyRate) /
                    (1 - Math.pow(1 + monthlyRate, -months));
 
            var rpsn = calculateRpsn(loanAmount, monthlyPayment, months, fee);
 
            var df = new DecimalFormat("#,##0.00");
 
            resultArea.setText("Měsíční splátka: " + df.format(monthlyPayment) + " Kč\n");
            resultArea.append("Odhadované RPSN: " + df.format(rpsn) + " %");
 
        } catch (NumberFormatException ex) {
            resultArea.setText("❗ Zadejte platná čísla!");
        }
    }
 
    private double calculateRpsn(double loanAmount, double monthlyPayment, int months, double fee) {
        final double precision = 1e-6;
        var rpsn = 0.01; // počáteční odhad (1 %)
        final double step = 0.0001;
 
        while (true) {
            var pv = 0.0;
            for (int i = 1; i <= months; i++) {
                pv += monthlyPayment / Math.pow(1 + rpsn, i / 12.0);
            }
 
            var target = loanAmount - fee;
            var diff = pv - target;
 
            if (Math.abs(diff) < precision) break;
 
            rpsn += (diff > 0) ? -step : step;
            if (rpsn < 0) rpsn = 0.0001;
        }
 
        return rpsn * 100;
    }
}