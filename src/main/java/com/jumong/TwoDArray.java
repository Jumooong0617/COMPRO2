package com.jumong;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class TwoDArray{

    public static final double VAT_RATE = 0.12;
    public static final String[][] COFFEE_MENU = {
            {"Espresso", "50.0"},
            {"Latte", "70.0"},
            {"Cappuccino", "65.0"},
            {"Mocha", "80.0"}
    };

    public static void main(String[] args) {
        String[][] COFFEE_MENU = {
                {"Espresso", "50.0"},
                {"Latte", "70.0"},
                {"Cappuccino", "65.0"},
                {"Mocha", "80.0"}
        };
        Scanner asd = new Scanner(System.in); // Scanner for user input
        int choice;
        int quantity;
        double total = 0.0;


        // store the count of each ordered coffee.
        int[] coffeeCounts = new int[COFFEE_MENU.length];


        // display menu
        menu();


        do {
            System.out.print("Choose your coffee (1-4, or 0 to finish): ");
            try {
                choice = asd.nextInt();


                if (choice > 4) {
                    System.out.println("Please choose your order from 0 - 4 only. Thank you.");
                    menu();
                    continue;
                }


                if (choice == 0) {
                    System.out.println("Finishing order...");
                    break;
                }


                System.out.print("Enter quantity: ");
                try {
                    quantity = asd.nextInt();


                    if (quantity <= 0) {
                        System.out.println("Quantity must be a positive number. Please try again.");
                        continue;
                    }


                    coffeeCounts[choice - 1] += quantity;
                    total += Double.parseDouble(COFFEE_MENU[choice - 1][1]) * quantity;


                    menu();


                } catch (Exception e) {
                    System.out.println("Invalid input for quantity. Please enter a valid number.");
                    asd.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Invalid input for choice. Please enter a number between 0 and 4.");
                asd.nextLine();
            }
        } while (true);


        printReceipt(coffeeCounts, total);
        asd.close();
    }


    /**
     * Prints the receipt for the coffee order, including each ordered item,
     * subtotal, VAT, and grand total.
     *
     * @param coffeeCounts An array containing the count of each coffee ordered.
     * @param total        The subtotal amount before VAT.
     */
    public static void printReceipt(int[] coffeeCounts, double total) {
        System.out.println("\n--- Coffee Order Receipt ---\n");


        // Print ordered coffee details
        for (int i = 0; i < COFFEE_MENU.length; i++) {
            if (coffeeCounts[i] > 0) {
                double price = Double.parseDouble(COFFEE_MENU[i][1]);
                System.out.printf("%d x %s @ %.2f each = %.2f%n", coffeeCounts[i], COFFEE_MENU[i][0], price, coffeeCounts[i] * price);
            }
        }


        System.out.print("-----------------------------\n");
        System.out.printf("Subtotal: %.2f%n", total);
        double vat = total * VAT_RATE;
        System.out.printf("VAT (12%%): %.2f%n", vat);
        System.out.printf("Grand Total: %.2f%n", total + vat);
        System.out.print("-----------------------------\n");
        System.out.print("Thank you for your order!\n");


        saveReceiptToFile(coffeeCounts, total, vat);
    }


    /**
     * Displays the coffee menu with coffee names and their respective prices.
     * Also includes an option for finishing the order.
     */
    public static void menu() {
        System.out.println();
        System.out.println("--- Coffee Menu ---");
        for (int i = 0; i < COFFEE_MENU.length; i++) {
            System.out.printf("%d. %s - %.2f PHP%n", i + 1, COFFEE_MENU[i][0], Double.parseDouble(COFFEE_MENU[i][1]));
        }
        System.out.println("0. Finish Order");
    }


    /**
     * Saves the receipt information to a file named "receipt.txt".
     * The file includes a list of the ordered items, subtotal, VAT, and grand total.
     *
     * @param coffeeCounts An array containing the count of each coffee ordered.
     * @param total        The subtotal amount before VAT.
     * @param vat          The VAT calculated on the subtotal.
     */
    public static void saveReceiptToFile(int[] coffeeCounts, double total, double vat) {
        try (FileWriter writer = new FileWriter("receipt.txt")) {
            writer.write("--- Coffee Order Receipt ---\n\n");


            for (int i = 0; i < COFFEE_MENU.length; i++) {
                if (coffeeCounts[i] > 0) {
                    double price = Double.parseDouble(COFFEE_MENU[i][1]);
                    writer.write(String.format("%d x %s @ %.2f each = %.2f%n", coffeeCounts[i], COFFEE_MENU[i][0], price, coffeeCounts[i] * price));
                }
            }


            writer.write("-----------------------------\n");
            writer.write(String.format("Subtotal: %.2f%n", total));
            writer.write(String.format("VAT (12%%): %.2f%n", vat));
            writer.write(String.format("Grand Total: %.2f%n", total + vat));
            writer.write("\n-----------------------------\n");
            writer.write("Thank you for your order!\n");


            System.out.println("Receipt saved to receipt.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the receipt.");
        }
    }
}
