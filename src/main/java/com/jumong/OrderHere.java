package com.jumong;

public class OrderHere {
    public static void main(String[] args) {
        // Create two Coffee objects
        Coffee coffee1 = new Coffee("Espresso", "Arabica", "Medium", 3.50, "Dark",
                "Colombia", false, 10, "Espresso Machine");
        Coffee coffee2 = new Coffee("Latte", "Robusta", "Large", 4.00, "Medium",
                "Brazil", false, 5, "Drip");

        // Call methods on the first coffee
        coffee1.addFlavor("Chocolate");
        coffee1.addFlavor("Nutty");
        coffee1.calculatePrice("Medium");
        coffee1.discount(10);
        coffee1.updateStock(-2);
        System.out.println(coffee1.describe());
        System.out.println("Price after discount: $" + coffee1.getPrice());
        System.out.println("Stock left: " + coffee1.getStock());

        // Call methods on the second coffee
        coffee2.addFlavor("Vanilla");
        coffee2.setDecaf(true);
        coffee2.changeRoastLevel("Light");
        coffee2.calculatePrice("Large");
        coffee2.updateStock(3);
        System.out.println(coffee2.describe());
        System.out.println("New Price: $" + coffee2.getPrice());
        System.out.println("Stock left: " + coffee2.getStock());
    }
}
