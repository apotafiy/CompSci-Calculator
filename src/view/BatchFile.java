package view;

import controller.Director;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

/**
 * GUI assosiated with Batch File Input
 */
public class BatchFile extends JFrame {

    BatchFile() {
        setTitle("Handy Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel northPanel = new JPanel();
        JLabel header = new JLabel("Batch File Input");

        northPanel.add(header);


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        JButton chooseFile = new JButton("Choose File");
        centerPanel.add(chooseFile);


        JTextField confirmation = new JTextField();
        confirmation.setEditable(false);
        confirmation.setPreferredSize(new Dimension(200, 20));


        centerPanel.add(confirmation);


        chooseFile.addActionListener(e -> {
            File inputFile;
            int response;
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setFileFilter(filter);

            response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                inputFile = fileChooser.getSelectedFile();
                try {
                    if (inputFile.isFile()) {
                        file(inputFile);
                        confirmation.setText("Check 'output.txt' for the results.");
                    } else confirmation.setText("ERROR: Invalid File Chosen.");
                } catch (Exception ex) {
                    confirmation.setText("ERROR: Invalid File Chosen.");
                }
            }
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


        pack();
        setVisible(true);
    }

    /**
     * Creates output file and reads the input file
     *
     * @throws IOException if improper file is selected
     */
    private static void file(File inputFile) throws IOException {
        File output = new File("output.txt");
        FileWriter fw = new FileWriter(output);
        PrintWriter pw = new PrintWriter(fw);
        Scanner scanner = new Scanner(inputFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().toLowerCase();
            String computation = Director.interpreter(line);
            String result = computation.startsWith("ERROR") ? "ERROR: Invalid command in your input file." :
                    computation;
            pw.println(result);

        }
        pw.close();
    }

}
