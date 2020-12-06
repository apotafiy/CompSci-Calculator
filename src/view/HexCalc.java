package view;

import controller.Director;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
/**
 * GUI associated with Hex Calculations
 */
public class HexCalc extends JFrame {

    HexCalc() {
        JLabel header = new JLabel("Hex Calculator");
        JPanel northPanel = new JPanel();
        northPanel.add(header);
        setTitle("Handy Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1));


        // Arithmetic
        {
            JPanel topPanel = new JPanel();
            topPanel.setLayout(new GridLayout(4, 1));

            JLabel calcTypeLabel = new JLabel("Add, Subtract, Multiply, or Divide");
            topPanel.add(calcTypeLabel);

            JPanel input = new JPanel();
            input.setLayout(new FlowLayout());

            JTextField mathTextOne = new JTextField();
            mathTextOne.setPreferredSize(new Dimension(70, 20));
            input.add(mathTextOne);

            String[] operators = {"+", "-", "/", "*"};
            JComboBox<String> operator = new JComboBox<>(operators);
            input.add(operator);

            JTextField mathTextTwo = new JTextField();
            mathTextTwo.setPreferredSize(new Dimension(70, 20));
            input.add(mathTextTwo);

            JButton calculateMath = new JButton("Calculate");
            JButton clearMath = new JButton("Clear");
            input.add(calculateMath);
            input.add(clearMath);

            topPanel.add(input);

            JPanel output = new JPanel();
            JTextArea calculationMath = new JTextArea();
            calculationMath.setRows(2);
            calculationMath.setPreferredSize(new Dimension(250, 40));
            calculationMath.setEditable(false);
            output.add(calculationMath);
            topPanel.add(output);

            calculateMath.addActionListener(e -> {
                String command =
                        "calculate hexadecimal " + Objects.requireNonNull(operator.getSelectedItem()).toString().trim() + " " + mathTextOne.getText().trim() + " " + mathTextTwo.getText().trim();
                calculationMath.setText(Director.interpreter(command));
            });
            clearMath.addActionListener(e -> {
                mathTextOne.setText("");
                mathTextTwo.setText("");
            });

            topPanel.add(new JSeparator());

            centerPanel.add(topPanel);
        }


        // Convert Binary to Decimal
        {
            JPanel midPanel = new JPanel();
            midPanel.setLayout(new GridLayout(4, 1));

            JLabel calcTypeLabel = new JLabel("Convert Hex Value to Decimal Value");

            midPanel.add(calcTypeLabel);
            JPanel input = new JPanel();

            JLabel label = new JLabel("Hex Value:");

            input.add(label);
            input.setLayout(new FlowLayout());
            JTextField binaryTextField = new JTextField();
            binaryTextField.setPreferredSize(new Dimension(150, 20));
            input.add(binaryTextField);

            JButton convertButton = new JButton("Convert");

            input.add(convertButton);
            JButton clear = new JButton("Clear");

            input.add(clear);

            JPanel output = new JPanel();
            JTextArea calculationArea = new JTextArea();
            calculationArea.setEditable(false);
            calculationArea.setPreferredSize(new Dimension(230, 25));
            output.add(calculationArea);

            convertButton.addActionListener(e -> {
                String command = "convert hexadecimal to decimal " + binaryTextField.getText();
                calculationArea.setText(Director.interpreter(command));
            });

            clear.addActionListener(e -> binaryTextField.setText(""));

            midPanel.add(input);
            midPanel.add(output);
            midPanel.add(new JSeparator());
            centerPanel.add(midPanel);
        }


        // Convert Decimal Value to Binary Value
        {
            JPanel lowPanel = new JPanel();
            lowPanel.setLayout(new GridLayout(4, 1));

            JLabel calcTypeLabel = new JLabel("Convert Decimal Value to Hex Value");

            lowPanel.add(calcTypeLabel);
            JPanel input = new JPanel();

            JLabel label = new JLabel("Decimal Value:");

            input.add(label);
            input.setLayout(new FlowLayout());
            JTextField binaryTextField = new JTextField();
            binaryTextField.setPreferredSize(new Dimension(150, 20));
            input.add(binaryTextField);

            JButton convertButton = new JButton("Convert");

            input.add(convertButton);
            JButton clear = new JButton("Clear");

            input.add(clear);

            JPanel output = new JPanel();
            JTextArea calculationArea = new JTextArea();
            calculationArea.setEditable(false);
            calculationArea.setPreferredSize(new Dimension(230, 25));
            output.add(calculationArea);

            convertButton.addActionListener(e -> {
                String command = "convert decimal to hexadecimal " + binaryTextField.getText();
                calculationArea.setText(Director.interpreter(command));
            });

            clear.addActionListener(e -> binaryTextField.setText(""));

            lowPanel.add(input);
            lowPanel.add(output);
            lowPanel.add(new JSeparator());
            centerPanel.add(lowPanel);
        }


        JButton mainMenu = new JButton("Return to Main Menu");
        mainMenu.addActionListener(e -> {
            dispose();
            new MainMenu();
        });
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        southPanel.add(mainMenu);


        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }
}
