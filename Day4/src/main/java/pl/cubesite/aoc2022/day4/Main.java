package pl.cubesite.aoc2022.day4;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        URL inputFile = Main.class.getClassLoader().getResource("input.txt");
        Scanner scanner;

        if (inputFile == null) {
            System.out.println("File not found: input.txt");
            return;
        }

        System.out.println("---------------- Part 1 ----------------");
        scanner = new Scanner(inputFile.openStream());
        System.out.println(task1(scanner) + " pairs");
        scanner.close();
        System.out.println("----------------------------------------");
        System.out.println(System.getProperty("line.separator"));

        System.out.println("---------------- Part 2 ----------------");
        scanner = new Scanner(inputFile.openStream());
        System.out.println(task2(scanner) + " pairs");
        scanner.close();
        System.out.println("----------------------------------------");
    }

    private static int task1(Scanner scanner) {
        int licznik = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.equals("")) {
                String[] parts = line.split(",");
                String[] part1 = parts[0].split("-");
                String[] part2 = parts[1].split("-");
                int start1 = Integer.parseInt(part1[0]);
                int end1 = Integer.parseInt(part1[1]);
                int start2 = Integer.parseInt(part2[0]);
                int end2 = Integer.parseInt(part2[1]);
                if ((start2 >= start1 && end2 <= end1) || (start1 >= start2 && end1 <= end2)) licznik++;
            }
        }
        return licznik;
    }

    private static int task2(Scanner scanner) {
        int licznik = 0;
        int lines = 0;
        while (scanner.hasNextLine()) {
            lines++;
            String line = scanner.nextLine();
            if (!line.equals("")) {
                String[] parts = line.split(",");
                String[] part1 = parts[0].split("-");
                String[] part2 = parts[1].split("-");
                int start1 = Integer.parseInt(part1[0]);
                int end1 = Integer.parseInt(part1[1]);
                int start2 = Integer.parseInt(part2[0]);
                int end2 = Integer.parseInt(part2[1]);
                if ((start1 < start2 && end1 < start2) || (start2 < start1 && end2 < start1)) licznik++;
            }
        }
        return lines - licznik;
    }
}