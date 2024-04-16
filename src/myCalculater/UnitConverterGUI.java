package myCalculater;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UnitConverterGUI extends JFrame {
    private JTextField inputField;
    private JComboBox<String> fromUnitComboBox;
    private JComboBox<String> toUnitComboBox;
    private JButton convertButton;
    private JLabel resultLabel;

    public UnitConverterGUI() {
        setTitle("Unit Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        addListeners();
    }

    private void initComponents() {
        inputField = new JTextField();
        fromUnitComboBox = new JComboBox<>(new String[]{"Fahrenheit", "Celsius", "Volts", "Amps"});
        toUnitComboBox = new JComboBox<>(new String[]{"Kelvin", "Ohms", "Watts"});
        convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result:");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(inputField)
                                        .addComponent(convertButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(resultLabel)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(fromUnitComboBox, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(toUnitComboBox, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(inputField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(fromUnitComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(toUnitComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(convertButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resultLabel)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void addListeners() {
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });
    }

    private void convert() {
        try {
            double inputValue = Double.parseDouble(inputField.getText());
            String fromUnit = (String) fromUnitComboBox.getSelectedItem();
            String toUnit = (String) toUnitComboBox.getSelectedItem();
            double result = performConversion(inputValue, fromUnit, toUnit);
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a number.");
        }
    }

    private double performConversion(double value, String fromUnit, String toUnit) {
        // Perform the conversion based on the selected units
        if ("Fahrenheit".equals(fromUnit) && "Kelvin".equals(toUnit)) {
            return (value - 32) / 1.8 + 273.15;
        } else if ("Celsius".equals(fromUnit) && "Kelvin".equals(toUnit)) {
            return value + 273.15;
        } else if ("Volts".equals(fromUnit) && "Ohms".equals(toUnit)) {
            return value;  // Resistance (Ohms) = Voltage (Volts)
        } else if ("Amps".equals(fromUnit) && "Ohms".equals(toUnit)) {
            return value;  // Resistance (Ohms) = Current (Amps)
        } else if ("Volts".equals(fromUnit) && "Watts".equals(toUnit)) {
            return value;  // Power (Watts) = Voltage (Volts)
        } else if ("Amps".equals(fromUnit) && "Watts".equals(toUnit)) {
            return value;  // Power (Watts) = Current (Amps)
        } else {
            // Handle other conversion cases if needed
            return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UnitConverterGUI().setVisible(true);
            }
        });
    }
}

