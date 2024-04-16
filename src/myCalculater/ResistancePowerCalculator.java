package myCalculater;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResistancePowerCalculator extends JFrame {

    private JTextField voltageField, currentField, resistanceField, powerField;

    public ResistancePowerCalculator() {
        super("Resistance and Power Calculator");

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create labels
        JLabel voltageLabel = new JLabel("Voltage (V):");
        JLabel currentLabel = new JLabel("Current (A):");
        JLabel resistanceLabel = new JLabel("Resistance (Ω):");
        JLabel powerLabel = new JLabel("Power (W):");

        // Create text fields
        voltageField = new JTextField(10);
        currentField = new JTextField(10);
        resistanceField = new JTextField(10);
        powerField = new JTextField(10);
        powerField.setEditable(false); // Power field should be read-only

        // Create calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });

        // Create layout using GroupLayout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(voltageLabel)
                        .addComponent(currentLabel)
                        .addComponent(resistanceLabel)
                        .addComponent(powerLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(voltageField)
                        .addComponent(currentField)
                        .addComponent(resistanceField)
                        .addComponent(powerField))
                .addComponent(calculateButton)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(voltageLabel)
                        .addComponent(voltageField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(currentLabel)
                        .addComponent(currentField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(resistanceLabel)
                        .addComponent(resistanceField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(powerLabel)
                        .addComponent(powerField))
                .addComponent(calculateButton)
        );

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void calculate() {
        try {
            double voltage = Double.parseDouble(voltageField.getText());
            double current = Double.parseDouble(currentField.getText());

            double resistance = voltage / current;
            double power = voltage * current;

            resistanceField.setText(String.format("%.2f", resistance));
            powerField.setText(String.format("%.2f", power));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for voltage and current.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ResistancePowerCalculator().setVisible(true);
            }
        });
    }
}
