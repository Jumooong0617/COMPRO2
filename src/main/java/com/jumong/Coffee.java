package com.jumong;

public class Coffee {
    public String name;
    public String type;
    public String size;
    public double price;
    public String roastLevel;
    public String origin;
    public boolean isDecaf;
    public int stock;
    public String[] flavorNotes;
    public int flavorCount;
    public String brewMethod;

    public Coffee(String name, String type, String size, double price, String roastLevel,
                  String origin, boolean isDecaf, int stock, String brewMethod) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
        this.roastLevel = roastLevel;
        this.origin = origin;
        this.isDecaf = isDecaf;
        this.stock = stock;
        this.brewMethod = brewMethod;
        this.flavorNotes = new String[5]; // Limiting flavor notes to 5 for simplicity
        this.flavorCount = 0;
    }

    public void calculatePrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                this.price = this.price * 1.0;
                break;
            case "medium":
                this.price = this.price * 1.2;
                break;
            case "large":
                this.price = this.price * 1.5;
                break;
            default:
                System.out.println("Invalid size. Keeping default price.");
        }
    }

    public boolean checkStock() {
        return this.stock > 0;
    }

    public void addFlavor(String note) {
        if (flavorCount < flavorNotes.length) {
            flavorNotes[flavorCount] = note;
            flavorCount++;
        } else {
            System.out.println("Cannot add more flavor notes. Maximum reached.");
        }
    }

    public void updateStock(int quantity) {
        this.stock += quantity;
    }

    public String describe() {
        String flavors = "";
        for (int i = 0; i < flavorCount; i++) {
            flavors += flavorNotes[i] + (i < flavorCount - 1 ? ", " : "");
        }
        return name + " (" + roastLevel + " roast) with flavors: " + (flavors.isEmpty() ? "None" : flavors) +
                ". Brewed using " + brewMethod + ".";
    }

    public void setDecaf(boolean isDecaf) {
        this.isDecaf = isDecaf;
    }

    public void changeRoastLevel(String newRoastLevel) {
        this.roastLevel = newRoastLevel;
    }

    public void discount(double percentage) {
        this.price -= this.price * (percentage / 100);
    }

    public double getPrice() {
        return this.price;
    }

    public int getStock() {
        return this.stock;
    }
}

