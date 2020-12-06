package view;


import controller.Director;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * GUI for Hosting Bandwidth Calculator
 */
public class HBWCalc extends JFrame {

    HBWCalc() {
        setTitle("Handy Calculator");

        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("Hosting Bandwidth Calculator"));


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 1));

        JPanel inputOne = new JPanel();
        JLabel fileSizeLabel = new JLabel("Monthly Usage ");
        inputOne.add(fileSizeLabel);

        JTextField inputOneText = new JTextField();
        inputOneText.setPreferredSize(new Dimension(50, 20));
        inputOne.add(inputOneText);

        String[] unitTypes = {"Bytes", "Kilobytes", "MegaBytes", "Gigabytes", "Terabytes"};
        JComboBox<String> unitType = new JComboBox<>(unitTypes);
        inputOne.add(unitType);

        centerPanel.add(inputOne);


        JPanel inputTwo = new JPanel();

        JLabel bandWidth = new JLabel("Bandwidth ");
        inputTwo.add(bandWidth);

        String[] rateTypes = {"bit/s", "Kbit/s", "Mbit/s", "Gbit/s", "Tbit/s"};
        JComboBox<String> rateType = new JComboBox<>(rateTypes);
        inputTwo.add(rateType);

        centerPanel.add(inputTwo);

        JPanel buttons = new JPanel();
        JButton calculate = new JButton("Calculate");
        buttons.add(calculate);
        JButton clear = new JButton("Clear");
        buttons.add(clear);
        centerPanel.add(buttons);

        JPanel output = new JPanel();
        JTextArea equivBandwidth = new JTextArea();
        equivBandwidth.setEditable(false);
        equivBandwidth.setPreferredSize(new Dimension(400, 30));
        equivBandwidth.setLineWrap(true);
        output.add(equivBandwidth);

        centerPanel.add(output);

        calculate.addActionListener(e -> {
            String command = "convert monthly usage to bandwidth " + inputOneText.getText() + " " +
                    Objects.requireNonNull(unitType.getSelectedItem()).toString() + " " + Objects.requireNonNull(rateType.getSelectedItem()).toString();
            equivBandwidth.setText(Director.interpreter(command));
        });

        clear.addActionListener(e -> inputOneText.setText(""));


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