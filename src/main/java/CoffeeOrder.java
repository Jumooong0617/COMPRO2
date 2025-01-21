import java.util.*;
public class CoffeeOrder {
    public static double price = 0;
    public static int order =0;
    public static int quantity = 0;
    public static Scanner asd = new Scanner(System.in);

    public static void main(String[] args) {
      menu();

            if (order <= 4 && order != 0) {
                menu();
            }
            if (order == 0) {
                receipt();
            } else {
                System.out.println("Invalid choice try again");
            }


        String coffeeName;
            switch (order) {
                case (1):
                    System.out.println("Espresso");
                    price = 50.00;
                    break;
                case (2):
                    System.out.println("Latte");
                    price = 70.00;
                    break;
                case (3):
                    System.out.println("Cappuccino");
                    price = 65.00;
                    break;
                case (4):
                    System.out.println("Mocha");
                    price = 80.00;
                    break;
                case (0):
                    System.out.println("Order Finished");
                    break;
                default:
                    System.out.println("Choose only from 1-4 and 0 for finishing order.");

        }
    }
    public static void menu () {
        System.out.println("--- Coffee Menu ---");
        System.out.print("""
                1. 1. Espresso - 50.00 PHP
                2. Latte - 70.00 PHP
                3. Cappuccino - 65.00 PHP
                4. Mocha - 80.00 PHP
                0. Finish Order
                """);
        System.out.print("Choose your coffee (1-4, or 0 to finish): ");
        order = asd.nextInt();
        System.out.print("Enter quantity: ");
        quantity = asd.nextInt();
        System.out.println("------------------------------------------");
    }
    public static void receipt () {
        System.out.println("receipt");
    }
}
