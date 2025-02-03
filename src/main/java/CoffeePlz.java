import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CoffeePlz {

    // constants for coffee prices
    static final double ESPRESSO_PRICE = 50.0;
    static final double LATTE_PRICE = 70.0;
    static final double CAPPUCCINO_PRICE = 65.0;
    static final double MOCHA_PRICE = 80.0;
    static final double VAT_RATE = 0.12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int quantity;
        double total = 0.0;

        // variables to store the count of each coffee type ordered
        int espressoCount = 0;
        int latteCount = 0;
        int cappuccinoCount = 0;
        int mochaCount = 0;

        // display menu
        menu();

        do {
            System.out.print("Choose your coffee (1-4, or 0 to finish): ");
            try {
                choice = scanner.nextInt();

                // check if the input is within the choices
                if (choice > 4) {
                    System.out.println("Please choose your order from 0 - 4 only. Thank you.");
                    menu();
                    continue;
                }

                // exit loop if user chooses 0
                if (choice == 0) {
                    System.out.println("Finishing order...");
                    break;
                }

                System.out.print("Enter quantity: ");
                try {
                    quantity = scanner.nextInt(); // Read quantity

                    // ensure the quantity is positive
                    if (quantity <= 0) {
                        System.out.println("Quantity must be a positive number. Please try again.");
                        continue;
                    }

                    // updates the total and coffee choice count based on the choice
                    switch (choice) {
                        case 1:
                            total += ESPRESSO_PRICE * quantity;
                            espressoCount += quantity;
                            break;
                        case 2:
                            total += LATTE_PRICE * quantity;
                            latteCount += quantity;
                            break;
                        case 3:
                            total += CAPPUCCINO_PRICE * quantity;
                            cappuccinoCount += quantity;
                            break;
                        case 4:
                            total += MOCHA_PRICE * quantity;
                            mochaCount += quantity;
                            break;
                        default:
                            System.out.println("Invalid choice. Please select again.");
                    }

                    // display menu
                    menu();

                } catch (Exception e) {
                    System.out.println("Invalid input for quantity. Please enter a valid number.");
                    scanner.nextLine(); // Clear invalid input
                }
            } catch (Exception e) {
                System.out.println("Invalid input for choice. Please enter a number between 0 and 4.");
                scanner.nextLine(); // Clear invalid input
            }
        } while (true);

        // print receipt and save it to a file
        printReceipt(espressoCount, latteCount, cappuccinoCount, mochaCount, total);

        scanner.close();
    }

    /**
     * Prints the receipt with the details of the coffee order, subtotal, VAT, and grand total,
     * and saves it to a file named "receipt.txt".
     *
     * @param espressoCount    number of espressos ordered
     * @param latteCount       number of lattes ordered
     * @param cappuccinoCount  number of cappuccinos ordered
     * @param mochaCount       number of mochas ordered
     * @param total            subtotal amount for the order
     */
    public static void printReceipt(int espressoCount, int latteCount, int cappuccinoCount, int mochaCount, double total) {
        System.out.println("\n--- Coffee Order Receipt ---\n");

        // Print details of each coffee type if ordered
        if (espressoCount > 0) {
            System.out.printf("%d x Espresso @ %.2f each = %.2f%n", espressoCount, ESPRESSO_PRICE, espressoCount * ESPRESSO_PRICE);
        }
        if (latteCount > 0) {
            System.out.printf("%d x Latte @ %.2f each = %.2f%n", latteCount, LATTE_PRICE, latteCount * LATTE_PRICE);
        }
        if (cappuccinoCount > 0) {
            System.out.printf("%d x Cappuccino @ %.2f each = %.2f%n", cappuccinoCount, CAPPUCCINO_PRICE, cappuccinoCount * CAPPUCCINO_PRICE);
        }
        if (mochaCount > 0) {
            System.out.printf("%d x Mocha @ %.2f each = %.2f%n", mochaCount, MOCHA_PRICE, mochaCount * MOCHA_PRICE);
        }

        // calculate VAT and grand total
        System.out.print("-----------------------------\n");
        System.out.printf("Subtotal: %.2f%n", total);
        double vat = total * VAT_RATE;
        System.out.printf("VAT (12%%): %.2f%n", vat);
        System.out.printf("Grand Total: %.2f%n", total + vat);
        System.out.print("-----------------------------\n");
        System.out.print("Thank you for your order!\n");

        // save receipt to  file
        saveReceiptToFile(espressoCount, latteCount, cappuccinoCount, mochaCount, total, vat);
    }

    /**
     * Displays the coffee menu with available options and prices.
     */
    public static void menu() {
        System.out.println();
        System.out.println("--- Coffee Menu ---");
        System.out.print("""
               1. Espresso - 50.00 PHP
               2. Latte - 70.00 PHP
               3. Cappuccino - 65.00 PHP
               4. Mocha - 80.00 PHP
               0. Finish Order
               """);
    }

    /**
     * Saves the receipt details to a text file named "receipt.txt".
     *
     * @param espressoCount    number of espressos ordered
     * @param latteCount       number of lattes ordered
     * @param cappuccinoCount  number of cappuccinos ordered
     * @param mochaCount       number of mochas ordered
     * @param total            subtotal amount for the order
     * @param vat              calculated VAT amount
     */
    public static void saveReceiptToFile(int espressoCount, int latteCount, int cappuccinoCount, int mochaCount, double total, double vat) {
        try (FileWriter writer = new FileWriter("receipt.txt")) {
            writer.write("--- Coffee Order Receipt ---\n\n");

            // Write details of each coffee type if ordered
            if (espressoCount > 0) {
                writer.write(String.format("%d x Espresso @ %.2f each = %.2f%n", espressoCount, ESPRESSO_PRICE, espressoCount * ESPRESSO_PRICE));
            }
            if (latteCount > 0) {
                writer.write(String.format("%d x Latte @ %.2f each = %.2f%n", latteCount, LATTE_PRICE, latteCount * LATTE_PRICE));
            }
            if (cappuccinoCount > 0) {
                writer.write(String.format("%d x Cappuccino @ %.2f each = %.2f%n", cappuccinoCount, CAPPUCCINO_PRICE, cappuccinoCount * CAPPUCCINO_PRICE));
            }
            if (mochaCount > 0) {
                writer.write(String.format("%d x Mocha @ %.2f each = %.2f%n", mochaCount, MOCHA_PRICE, mochaCount * MOCHA_PRICE));
            }

            // Write VAT and total amounts
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