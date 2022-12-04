package pl.cubesite.aoc2022.day3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        URL itemsFile = Main.class.getClassLoader().getResource("items.txt");
        ArrayList<Character> itemTypes = new ArrayList<>();
        char ch;
        int prioritiesSum;

        Scanner scanner;

        if (itemsFile == null) {
            System.out.println("File not found: items.txt");
            return;
        }

        for( ch = 'a' ; ch <= 'z' ; ch++ ) itemTypes.add(ch);
        for( ch = 'A' ; ch <= 'Z' ; ch++ ) itemTypes.add(ch);

        scanner = new Scanner(itemsFile.openStream());
        prioritiesSum = task1(scanner, itemTypes);
        scanner.close();

        System.out.println("---------------- Part 1 ----------------");
        System.out.println("Sum: " + prioritiesSum);
        System.out.println("----------------------------------------");
        System.out.println(System.getProperty("line.separator"));

        scanner = new Scanner(itemsFile.openStream());
        prioritiesSum = task2(scanner, itemTypes);
        scanner.close();

        System.out.println("---------------- Part 2 ----------------");
        System.out.println("Sum: " + prioritiesSum);
        System.out.println("----------------------------------------");
    }

    private static int task1(Scanner scanner, ArrayList<Character> itemTypes) {
        String firstCompartment, secondCompartment;
        int prioritiesSum = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            ArrayList<Character> ch1 = new ArrayList<>();
            if (!line.equals("")) {
                firstCompartment = line.substring(0, line.length()/2);
                secondCompartment = line.substring(line.length()/2);
                for (int i = 0; i < line.length()/2; i++) ch1.add(firstCompartment.charAt(i));
                for (char c: ch1)
                    if (secondCompartment.contains(String.valueOf(c))) {
                        prioritiesSum += itemTypes.indexOf(c)+1;
                        break;
                    }
            }
        }
        return prioritiesSum;
    }

    private static int task2(Scanner scanner, ArrayList<Character> itemTypes) {
        int prioritiesSum = 0;
        int counter = 0;

        while (scanner.hasNextLine()) {
            ArrayList<Character> line1 = new ArrayList<>();
            String line, line2, line3;
            if (++counter % 3 == 1) {
                try {
                    line = scanner.next();
                    for (int i = 0; i < line.length(); i++) line1.add(line.charAt(i));
                    line2 = scanner.next();
                    line3 = scanner.next();
                    for (char c: line1)
                        if (line2.contains(String.valueOf(c)) && line3.contains(String.valueOf(c))) {
                            prioritiesSum += itemTypes.indexOf(c) + 1;
                            break;
                        }
                } catch (NoSuchElementException e) {
                    break;
                }
            }
        }
        return prioritiesSum;
    }
}