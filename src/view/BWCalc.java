package view;

import javax.swing.*;
import java.awt.*;

/**
 * GUI Menu for choosing desired Bandwidth Calculator
 */
public class BWCalc extends JFrame {

    BWCalc() {
        setTitle("Handy Calculator");

        JPanel centerPanel = new JPanel();

        GridLayout gridLayout = new GridLayout(2, 2);

        gridLayout.setVgap(3);
        gridLayout.setHgap(3);
        centerPanel.setLayout(gridLayout);

        JButton dataUnitConvert = new JButton("Data Unit Converter");
        dataUnitConvert.addActionListener(e -> {
            dispose();
            new DataUnitConverter();
        });

        JButton downUpTime = new JButton("Download/Upload Time Calculator");
        downUpTime.addActionListener(e -> {
            dispose();
            new DownUpTimeCalc();
        });

        JButton webBWCalc = new JButton("Website Bandwidth Calculator");
        webBWCalc.addActionListener(e->{
            dispose();
            new WBCalc();
        });

        JButton hostBWCalc = new JButton("Hosting Bandwidth Calculator");
        hostBWCalc.addActionListener(e->{
            dispose();
            new HBWCalc();
        });

        centerPanel.add(dataUnitConvert);
        centerPanel.add(downUpTime);
        centerPanel.add(webBWCalc);
        centerPanel.add(hostBWCalc);


        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(210, 210, 210));
        JLabel header = new JLabel("Bandwidth Calculator");
        northPanel.add(header);
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);



        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton mainMenu = new JButton("Return to Main Menu");
        mainMenu.addActionListener(e->{
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
