package view;

import controller.Director;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * GUI for Download/Upload Time Calculator
 */
public class DownUpTimeCalc extends JFrame {

    DownUpTimeCalc() {
        setTitle("Handy Calculator");

        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("Download/Upload Time Calculator"));


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 1));

        JPanel inputOne = new JPanel();
        JLabel fileSizeLabel = new JLabel("File Size ");
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

        JTextField inputTwoText = new JTextField();
        inputTwoText.setPreferredSize(new Dimension(50, 20));
        inputTwo.add(inputTwoText);

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
        JTextArea timeResult = new JTextArea();
        timeResult.setEditable(false);
        timeResult.setPreferredSize(new Dimension(500, 30));
        timeResult.setLineWrap(true);
        output.add(timeResult);

        centerPanel.add(output);


        calculate.addActionListener(e -> {
            String command =
                    "calculate download/upload time " + inputOneText.getText() + " " +
                            Objects.requireNonNull(unitType.getSelectedItem()).toString() + " " + inputTwoText.getText() + " " +
                            Objects.requireNonNull(rateType.getSelectedItem()).toString();
            timeResult.setText(Director.interpreter(command));
        });

        clear.addActionListener(e -> {
            inputOneText.setText("");
            inputTwoText.setText("");
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
