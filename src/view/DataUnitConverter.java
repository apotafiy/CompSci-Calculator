package view;

import controller.Director;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * GUI for Data Unit Converter
 */
public class DataUnitConverter extends JFrame {

    DataUnitConverter() {
        JLabel header = new JLabel("Data Unit Converter");
        JPanel northPanel = new JPanel();
        northPanel.add(header);
        setTitle("Handy Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel dataConvertPanel = new JPanel();
        dataConvertPanel.setLayout(new BorderLayout());

        JPanel input = new JPanel();
        JTextField dataUnitTextField = new JTextField();
        dataUnitTextField.setPreferredSize(new Dimension(100, 20));
        input.add(dataUnitTextField);

        String[] unitTypes = {"bits", "kilobits", "megabits", "gigabits", "terabits", "Bytes", "Kilobytes", "Megabytes",
                "Gigabytes", "Terabytes"};
        JComboBox<String> unitType = new JComboBox<>(unitTypes);
        input.add(unitType);

        JButton calculate = new JButton("Convert");

        input.add(calculate);

        JButton clear = new JButton("Clear");
        clear.addActionListener(e -> dataUnitTextField.setText(""));
        input.add(clear);

        JPanel output = new JPanel();
        JTextArea conversionsText = new JTextArea();
        conversionsText.setRows(11);
        conversionsText.setPreferredSize(new Dimension(300, 150));
        conversionsText.setEditable(false);

        output.add(conversionsText, BorderLayout.CENTER);


        calculate.addActionListener(e -> {
            String command = "convert data unit to " + Objects.requireNonNull(unitType.getSelectedItem()).toString() + " " + dataUnitTextField.getText();
            conversionsText.setText(Director.interpreter(command));
        });

        dataConvertPanel.add(input, BorderLayout.NORTH);
        dataConvertPanel.add(output, BorderLayout.CENTER);

        add(northPanel, BorderLayout.NORTH);
        add(dataConvertPanel, BorderLayout.CENTER);

        // Main Menu Button
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton mainMenu = new JButton("Return to Main Menu");
        mainMenu.addActionListener(e -> {
            dispose();
            new MainMenu();
        });
        southPanel.add(mainMenu);
        add(southPanel, BorderLayout.SOUTH);


        pack();
        setVisible(true);
    }

}