package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.*;

/**
 * Controls the flow of the program
 */
public class Director {

    /**
     * prints generic error message
     */
    @SuppressWarnings("SameReturnValue")
    private static String error() {
        return "ERROR: Invalid Input, Please Try Again.";
    }

    /**
     * Prints instructions
     */
    private static void help() {

        System.out.println();
        for (int i = 0; i < 80; i++) {
            System.out.print("'");
        }
        System.out.println();
        System.out.println("INSTRUCTIONS");
        System.out.println();
        System.out.println("Program Commands:");
        System.out.println("\t-help\t(prints these instructions again)");
        System.out.println("\t-file\t(takes 'input.txt' and runs the calculations/instructions in it)");
        System.out.println("\t-quit\t(terminates program)");
        System.out.println();
        System.out.println("How To Do Calculator Commands:");
        System.out.println("\tCalculator commands should be identical to one line of the input file commands.");
        System.out.println("\tEnter your command in the same format as the commands in your file input.");
        System.out.println("\tExamples:");
        System.out.println("\t\tCalculate binary + 1001 1001");
        System.out.println("\t\tConvert binary to decimal 101010101010101");
        System.out.println("\t\tCalculate hexadecimal + 4bf 44f");
        System.out.println("\t\tConvert decimal to hexadecimal 12435");
        System.out.println("\t\tConvert data unit to Bytes 721");
        System.out.println("\t\tCalculate Download/Upload Time 12 Bytes 6 bit/s");
        System.out.println("\t\tCalculate Website Bandwidth 5 per hour 16 Bytes 4");
        System.out.println("\t\tConvert Monthly Usage to Bandwidth 11 Bytes bit/s");
        System.out.println("\t(More examples can be found in 'testInput.txt')");

    }

    /**
     * Creates output file and reads the input file
     *
     * @throws IOException if improper file is selected
     */
    private static void file() throws IOException {
        File output = new File("output.txt");
        FileWriter fw = new FileWriter(output);
        PrintWriter pw = new PrintWriter(fw);
        Scanner scanner = new Scanner(new File("input.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().toLowerCase();
            String computation = interpreter(line);
            String result = computation.startsWith("ERROR") ? "ERROR: Invalid command in your input file." :
                    computation;
            pw.println(result);

        }
        pw.close();
    }

    /**
     * @param commands string[] of the user input
     * @return the desired calculation/conversion or empty String if ERROR occurs
     */
    private static String calculations(String[] commands) {
        if (commands.length < 5) {
            return error();
        }
        HexCalculator hexCalc = new HexCalculator();
        BinaryCalculator binCalc = new BinaryCalculator();
        SizeUnit sizeUnit;
        RateUnit rateUnit;
        FrequencyUnit frequencyUnit;
        Num number;
        Num number2;
        switch (commands[1]) {
            case "binary": {
                try {
                    long num = Long.parseLong(binCalc.convertToDec(commands[3]));
                    long num2 = Long.parseLong(binCalc.convertToDec(commands[4]));
                    number = new BinaryNumber(num);
                    number2 = new BinaryNumber(num2);

                    switch (commands[2]) {
                        case "+": {
                            return "Binary Value: " + binCalc.add(number, number2).toString() + "\nDecimal Value: " + (num + num2);
                        }
                        case "-": {
                            return "Binary Value: " + binCalc.subtract(number, number2).toString() + "\nDecimal Value: " + (num - num2);
                        }
                        case "/": {
                            if (num2 == 0) {
                                return "ERROR: Cannot Divide By Zero.";
                            }
                            return "Binary Value: " + binCalc.divide(number, number2).toString() + " Remainder: " + binCalc.convertToBase((number.getValue() % number2.getValue())) +
                                    "\nDecimal Value: " + (num / num2) + " Remainder: " + (number.getValue() % number2.getValue());
                        }
                        case "*": {
                            return "Binary Value: " + binCalc.add(number, number2).toString() +
                                    "\nDecimal Value: " + (num * num2);
                        }
                        default: {
                            return error();

                        }
                    }
                } catch (Exception e) {
                    return error();
                }
            }
            case "hexadecimal": {
                try {
                    long num = Long.parseLong(hexCalc.convertToDec(commands[3]));
                    long num2 = Long.parseLong(hexCalc.convertToDec(commands[4]));
                    number = new HexNumber(num);
                    number2 = new HexNumber(num2);
                    switch (commands[2]) {
                        case "+": {
                            return "Hex Value: " + hexCalc.add(number, number2).toString() + "\nDecimal Value: " + (num + num2);
                        }
                        case "-": {
                            return "Hex Value: " + hexCalc.subtract(number, number2).toString() + "\nDecimal Value: " + (num - num2);
                        }
                        case "/": {
                            if (num2 == 0) {
                                return "ERROR: Cannot Divide By Zero.";
                            }
                            return "Hex Value: " + hexCalc.divide(number, number2).toString() + " Remainder: " + hexCalc.convertToBase((number.getValue() % number2.getValue())) +
                                    "\nDecimal Value: " + (num / num2) + " Remainder: " + (number.getValue() % number2.getValue());
                        }
                        case "*": {
                            return "Hex Value: " + hexCalc.multiply(number, number2).toString() + "\nDecimal Value: " + (num * num2);
                        }
                        default: {
                            return error();
                        }
                    }
                } catch (IllegalArgumentException e) {
                    return error();
                }
            }
            case "upload":
            case "download":
            case "download/upload": {
                if (commands.length < 7) {
                    return error();
                }
                try {
                    double magnitudeSize = Double.parseDouble(commands[3]);
                    sizeUnit = new SizeUnit(magnitudeSize, SizeUnit.SizeU.valueOf(commands[4].toUpperCase()));
                    double magnitudeRate = Double.parseDouble(commands[5]);
                    rateUnit = new RateUnit(magnitudeRate, RateUnit.RateU.valueOf(commands[6].toUpperCase().substring(0,
                            commands[6].length() - 2)));
                    return BandWidthCalculator.DUTCalculator(sizeUnit, rateUnit);
                } catch (IllegalArgumentException e) {
                    return error();
                }
            }
            case "website": {
                if (commands.length < 9) {
                    return error();
                }
                try {
                    double magnitudeFreq = Double.parseDouble(commands[3]);
                    frequencyUnit = new FrequencyUnit(magnitudeFreq, FrequencyUnit.FrequencyU.valueOf(commands[5].toUpperCase()));


                    double magnitudeSize = Double.parseDouble(commands[6]);
                    sizeUnit = new SizeUnit(magnitudeSize, SizeUnit.SizeU.valueOf(commands[7].toUpperCase()));


                    int redundancy = Integer.parseInt(commands[8]);

                    return BandWidthCalculator.WBCalculator(frequencyUnit, sizeUnit, redundancy);
                } catch (IllegalArgumentException e) {
                    return error();
                }
            }
            default: {
                return error();
            }
        }
    }

    /**
     * @param commands string[] of the user input
     * @return the desired calculation/conversion or empty String if ERROR occurs
     */
    @SuppressWarnings("DuplicatedCode")
    private static String conversions(String[] commands) {
        if (commands.length < 5) {
            return error();
        }
        HexCalculator calcHex = new HexCalculator();
        BinaryCalculator calcBin = new BinaryCalculator();
        SizeUnit sizeUnit;
        switch (commands[1]) {
            case "binary": {
                if (commands[3].equals("decimal")) {
                    for (char c : commands[4].toCharArray()) {
                        if (c != '1' && c != '0') {
                            return error();
                        }
                    }
                    return calcBin.convertToDec(commands[4]);
                } else {
                    return error();
                }
            }
            case "hexadecimal": {
                if (commands[3].equals("decimal")) {
                    for (char c : commands[4].toCharArray()) {
                        List<Character> list = new ArrayList<>();
                        {
                            list.add('0');
                            list.add('1');
                            list.add('2');
                            list.add('3');
                            list.add('4');
                            list.add('5');
                            list.add('6');
                            list.add('7');
                            list.add('8');
                            list.add('9');
                            list.add('a');
                            list.add('b');
                            list.add('c');
                            list.add('d');
                            list.add('e');
                            list.add('f');
                        }
                        if (!list.contains(c)) {
                            return error();
                        }
                    }
                    return calcHex.convertToDec(commands[4]);
                } else {
                    return error();
                }
            }
            case "decimal": {
                if (commands[3].equals("binary")) {
                    try {
                        double val = Double.parseDouble(commands[4]);
                        return calcBin.convertToBase(val);
                    } catch (NumberFormatException e) {
                        return error();
                    }
                } else if (commands[3].equals("hexadecimal")) {
                    try {
                        double val = Double.parseDouble(commands[4]);
                        return calcHex.convertToBase(val);
                    } catch (NumberFormatException e) {
                        return error();
                    }
                } else {
                    return error();
                }
            }
            case "data": {
                if (commands.length < 6) {
                    return error();
                }
                try {
                    sizeUnit = new SizeUnit(Double.parseDouble(commands[5]),
                            SizeUnit.SizeU.valueOf(commands[4].toUpperCase()));
                    return BandWidthCalculator.DUConverter(sizeUnit);
                } catch (IllegalArgumentException e) {
                    return error();
                }
            }
            case "monthly": {
                if (commands.length < 8) {
                    return error();
                }
                try {
                    sizeUnit = new SizeUnit(Double.parseDouble(commands[5]), SizeUnit.SizeU.valueOf(commands[6].toUpperCase()));
                    // turns 'bit/s' into 'BIT' and returns
                    return BandWidthCalculator.HBConverter(sizeUnit,
                            RateUnit.RateU.valueOf(commands[commands.length - 1].toUpperCase().substring(0,
                                    commands[commands.length - 1].length() - 2))); // horrible readability
                } catch (IllegalArgumentException e) {
                    return error();
                }
            }
            default: {
                return error();
            }
        }
    }

    /**
     * @param command user input
     * @return the desired calculation/conversion or empty String if ERROR occurs
     */
    public static String interpreter(String command) {
        String[] commands = command.trim().toLowerCase().split("\\s+");// go easy on the interpretations(i.e. dont be
        // strict)
        if (commands.length < 1) {
            return error();
        }
        switch (commands[0]) {
            case "calculate":
                return calculations(commands);
            case "convert": {
                return conversions(commands);
            }
            case "help":
            case "-help": {
                help();
                return "";
            }
            case "file":
            case "-file": {
                try {
                    file();
                } catch (IOException e) {
                    System.out.println("ERROR: Could not find 'input.txt'.");
                    return "";
                }
                return "Check 'output.txt' for file output.";
            }
            case "-quit":
            case "quit":
            case "//": {
                return " ";
            }
            default: {
                if (commands[0].startsWith("//")) {
                    return "";
                }
                return error();
            }
        }
    }
}
