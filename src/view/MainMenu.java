package view;

import javax.swing.*;
import java.awt.*;

/**
 * GUI for Main Menu
 */
public class MainMenu extends JFrame {

    MainMenu() {
        setTitle("Handy Calculator");

        JPanel centerPanel = new JPanel();

        GridLayout gridLayout = new GridLayout(2, 2);

        gridLayout.setVgap(3);
        gridLayout.setHgap(3);
        centerPanel.setLayout(gridLayout);

        JButton binaryCalc = new JButton("Binary Calculator");
        binaryCalc.addActionListener(e -> {
            dispose();
            new BinCalc();
        });

        JButton hexCalc = new JButton("Hex Calculator");
        hexCalc.addActionListener(e -> {
            dispose();
            new HexCalc();
        });

        JButton bandWidthCalc = new JButton("Bandwidth Calculator");
        bandWidthCalc.addActionListener(e -> {
            dispose();
            new BWCalc();
        });

        JButton file = new JButton("Batch File Input");
        file.addActionListener(e -> {
            dispose();
            new BatchFile();
        });

        centerPanel.add(binaryCalc);
        centerPanel.add(hexCalc);
        centerPanel.add(bandWidthCalc);
        centerPanel.add(file);

        JPanel northPanel = new JPanel();
        JLabel header = new JLabel("Main Menu");
        northPanel.add(header);
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }
}
