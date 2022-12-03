package pl.cubesite.aoc2022.day2;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        URL answersFile = Main.class.getClassLoader().getResource("answers.txt");
        Scanner scanner;
        int points, rock = 1, paper = 2, scissors = 3, lost = 0, draw = 3, win = 6;
        int grl = rock + lost, grd = rock + draw, grw = rock + win, gpl = paper + lost, gpd = paper + draw, gpw = paper + win, gsl = scissors + lost, gsd = scissors + draw, gsw = scissors + win;

        if (answersFile == null) {
            System.out.println("File not found: answers.txt");
            return;
        }

        scanner = new Scanner(answersFile.openStream());
        points = task(scanner, grd, gpw, gsl, grl, gpd, gsw, grw, gpl, gsd);
        scanner.close();

        System.out.println("---------------- Part 1 ----------------");
        System.out.println("Score: " + points);
        System.out.println("----------------------------------------");
        System.out.println(System.getProperty("line.separator"));

        scanner = new Scanner(answersFile.openStream());
        points = task(scanner, gsl, grd, gpw, grl, gpd, gsw, gpl, gsd, grw);
        scanner.close();

        System.out.println("---------------- Part 2 ----------------");
        System.out.println("Score: " + points);
        System.out.println("----------------------------------------");
    }

    private static int task(Scanner scanner, int g1, int g2, int g3, int g4, int g5, int g6, int g7, int g8, int g9) {
        int points = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.equals("")) {
                if (line.contains("A")) {
                    if (line.contains("X")) points += g1;
                    else if (line.contains("Y")) points += g2;
                    else if (line.contains("Z")) points += g3;
                    else {
                        System.out.println("Unknown value: " + line);
                        return 0;
                    }
                }
                else if (line.contains("B")) {
                    if (line.contains("X")) points += g4;
                    else if (line.contains("Y")) points += g5;
                    else if (line.contains("Z")) points += g6;
                    else {
                        System.out.println("Unknown value: " + line);
                        return 0;
                    }
                }
                else if (line.contains("C")) {
                    if (line.contains("X")) points += g7;
                    else if (line.contains("Y")) points += g8;
                    else if (line.contains("Z")) points += g9;
                    else {
                        System.out.println("Unknown value: " + line);
                        return 0;
                    }
                }
                else {
                    System.out.println("Unknown value: " + line);
                    return 0;
                }
            }
        }
        return points;
    }
}