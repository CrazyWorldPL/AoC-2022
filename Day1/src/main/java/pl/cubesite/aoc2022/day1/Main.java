package pl.cubesite.aoc2022.day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputStream caloriesFile = Main.class.getResourceAsStream("/calories.txt");
        int calories = 0;
        ArrayList<Integer> caloriesList = new ArrayList<>();

        if (caloriesFile == null) {
            System.out.println("File not found: calories.txt");
            return;
        }

        Scanner scanner = new Scanner(caloriesFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.equals("")) calories += Integer.parseInt(line);
            else {
                caloriesList.add(calories);
                calories = 0;
            }
        }
        scanner.close();

        System.out.println("---------------- Part 1 ----------------");
        System.out.println("Most calories: " + Collections.max(caloriesList));
        System.out.println("----------------------------------------");
        System.out.println(System.getProperty("line.separator"));

        Collections.sort(caloriesList);
        Collections.reverse(caloriesList);

        int elf1 = caloriesList.get(0), elf2 = caloriesList.get(1), elf3 = caloriesList.get(2);

        System.out.println("---------------- Part 2 ----------------");
        System.out.println("Elf 1: " + elf1);
        System.out.println("Elf 2: " + elf2);
        System.out.println("Elf 3: " + elf3);
        System.out.println("Total: " + (elf1 + elf2 + elf3));
        System.out.println("----------------------------------------");
    }
}