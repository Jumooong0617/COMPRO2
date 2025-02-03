package com.jumong;
import java.io.*;
import java.util.Scanner;





public class GradeCalculator {
    public static final double MIN_GRADE = 50;
    public static final String FILE_DIR = "target/records";
    public static final int TOTAL_SUBJECTS = 64;


    public static void main(String[] args) {
        String name;
        String[] terms = {"Prelim", "Midterm", "Finals"};
        String[] subjects = new String[TOTAL_SUBJECTS];
        double[][] grades = new double[TOTAL_SUBJECTS][terms.length];


        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter name: ");
        name = scanner.nextLine().trim();


        for (int i = 0; i < TOTAL_SUBJECTS; i++) {
            System.out.print("Enter subject " + (i + 1) + ": ");
            subjects[i] = scanner.nextLine().trim();


            for (int j = 0; j < terms.length; j++) {
                while (true) {
                    try {
                        System.out.print("\t" + terms[j] + ": ");
                        grades[i][j] = Double.parseDouble(scanner.nextLine());


                        if (grades[i][j] < MIN_GRADE) {
                            System.out.println("\tInvalid grade, must be at least " + MIN_GRADE);
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("\tInvalid input. Please enter a numeric grade.");
                    }
                }
            }


            System.out.print("Add subject (y/n): ");
            char c = scanner.nextLine().toLowerCase().charAt(0);
            if (c != 'y') break;
        }


        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n\n");


        sb.append(String.format("%-15s%10s%10s%10s%15s\n", "Subject", terms[0], terms[1], terms[2], "Final Rating"));
        sb.append("------------------------------------------------------------\n");


        for (int i = 0; i < TOTAL_SUBJECTS; i++) {
            if (subjects[i] == null) break;


            sb.append(String.format("%-15s", subjects[i]));


            for (int j = 0; j < terms.length; j++) {
                sb.append(String.format("%10.2f", grades[i][j]));
            }


            sb.append(String.format("%15.2f", getFinalRating(grades[i])));
            sb.append("\n");
        }


        System.out.println(sb.toString());


        writeToFile(name, sb.toString());


        System.out.println("\n\nReading Files -----------------");
        readAllFiles();
    }


    /**
     * Computes the final rating using:
     * 30% of Prelim + 30% of Midterm + 40% of Finals
     */
    public static double getFinalRating(double[] termGrades) {
        return termGrades[0] * 0.3 + termGrades[1] * 0.3 + termGrades[2] * 0.4;
    }


    /**
     * Writes the student's data to a file.
     */
    public static void writeToFile(String fileName, String data) {
        File folder = new File(FILE_DIR);
        if (!folder.exists()) {
            folder.mkdirs();
        }


        File file = new File(folder, fileName + ".txt");


        try (FileWriter fw = new FileWriter(file)) {
            fw.write(data);
            System.out.println("File saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }


    /**
     * Reads all student grade files from the directory.
     */
    public static void readAllFiles() {
        File folder = new File(FILE_DIR);
        File[] studentGradeFiles = folder.listFiles();


        if (studentGradeFiles == null || studentGradeFiles.length == 0) {
            System.out.println("No records found.");
            return;
        }


        for (File file : studentGradeFiles) {
            if (file.isFile()) {
                readFile(file);
            }
        }
    }


    /**
     * Reads a specific file and displays its content.
     */
    public static void readFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            System.out.println("--------------------------");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

