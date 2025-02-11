package com.jumong;

public class Objects1 {
    public static void main(String[] args) {

        Objects2 coffee1 = new Objects2("Espresso", "Arabica", "Medium", 75.00, "Dark",
                "Colombia", false, 10, "Espresso Machine");
        Objects2 coffee2 = new Objects2("Latte", "Robusta", "Large", 80.00, "Medium",
                "Brazil", false, 5, "Drip");

        System.out.println("Available stock: " + coffee1.getStock());
        System.out.println("=========================================================================================");
        System.out.println("Order Description: ");
        coffee1.addFlavor("Chocolate");
        coffee1.addFlavor("Nutty");
        coffee1.calculatePrice("Medium");
        coffee1.discount(10);
        coffee1.updateStock(-2);
        System.out.println(coffee1.describe());
        System.out.println("Price after discount: ₱" + coffee1.getPrice());

        coffee2.addFlavor("Vanilla");
        coffee2.setDecaf(true);
        coffee2.changeRoastLevel("Light");
        coffee2.calculatePrice("Large");
        coffee2.updateStock(3);
        System.out.println(coffee2.describe());
        System.out.println("New Price: ₱" + coffee2.getPrice());
        System.out.println("=========================================================================================");
        System.out.println();
        System.out.println("Stock left: " + coffee2.getStock());
    }
}

