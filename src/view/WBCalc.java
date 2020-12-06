package view;


import controller.Director;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * GUI for Website Bandwidth Calculator
 */
public class WBCalc extends JFrame {

    WBCalc() {
        setTitle("Handy Calculator");

        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("Website Bandwidth Calculator"));


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5, 1));

        JPanel inputOne = new JPanel();
        JLabel viewCountLabel = new JLabel("Page Views ");
        inputOne.add(viewCountLabel);

        JTextField inputOneText = new JTextField();
        inputOneText.setPreferredSize(new Dimension(50, 20));
        inputOne.add(inputOneText);

        String[] frequencyTypes = {"per second", "per minute", "per hour", "per day", "per week", "per month",
                "per year"};
        JComboBox<String> frequencyType = new JComboBox<>(frequencyTypes);
        inputOne.add(frequencyType);

        centerPanel.add(inputOne);


        JPanel inputTwo = new JPanel();

        JLabel bandWidth = new JLabel("Average Page Size ");
        inputTwo.add(bandWidth);

        JTextField inputTwoText = new JTextField();
        inputTwoText.setPreferredSize(new Dimension(50, 20));
        inputTwo.add(inputTwoText);

        String[] unitTypes = {"Bytes", "Kilobytes", "MegaBytes", "Gigabytes", "Terabytes"};
        JComboBox<String> unitType = new JComboBox<>(unitTypes);
        inputTwo.add(unitType);

        centerPanel.add(inputTwo);


        JPanel inputThree = new JPanel();
        inputThree.add(new JLabel("Redundancy Factor "));
        JTextField inputThreeText = new JTextField();
        inputThreeText.setPreferredSize(new Dimension(50, 20));
        inputThree.add(inputThreeText);

        centerPanel.add(inputThree);

        JPanel buttons = new JPanel();
        JButton calculate = new JButton("Calculate");
        buttons.add(calculate);
        JButton clear = new JButton("Clear");
        buttons.add(clear);
        centerPanel.add(buttons);


        JPanel output = new JPanel();
        JTextArea requiredBandwidth = new JTextArea();
        requiredBandwidth.setEditable(false);
        requiredBandwidth.setPreferredSize(new Dimension(700, 35));
        requiredBandwidth.setLineWrap(true);
        output.add(requiredBandwidth);

        centerPanel.add(output);


        calculate.addActionListener(e -> {
            String command =
                    "calculate website bandwidth " + inputOneText.getText() + " " + Objects.requireNonNull(frequencyType.getSelectedItem()).toString() +
                            " " + inputTwoText.getText() + " " + Objects.requireNonNull(unitType.getSelectedItem()).toString() + " " + inputThreeText.getText();
            requiredBandwidth.setText(Director.interpreter(command));
        });

        clear.addActionListener(e -> {
            inputOneText.setText("");
            inputTwoText.setText("");
            inputThreeText.setText("");
        });


        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton mainMenu = new JButton("Return to Main Menu");
        mainMenu.addActionListener(e -> {
            dispose();
            new MainMenu();
        });
        southPanel.add(mainMenu);
        add(southPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
