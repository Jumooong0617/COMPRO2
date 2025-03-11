package com.jumong.springboot;

import java.util.List;

/**
 * The Coffee class represents a coffee product with various attributes.
 * It includes details such as the coffee's ID, name, type, size, price, roast level,
 * origin, whether it is decaffeinated, stock available, flavor notes, and brew method.
 */
public class Coffee {

    private int id;
    private String name;
    private String type;
    private String size;
    private double price;
    private String roastLevel;
    private String origin;
    private boolean isDecaf;
    private int stock;
    private List<String> flavorNotes;
    private String brewMethod;

    /**
     * Default constructor for the Coffee class.
     */
    public Coffee() {

    }

    /**
     * Constructor for the Coffee class with parameters to initialize the coffee attributes.
     *
     * @param id The unique identifier for the coffee.
     * @param name The name of the coffee.
     * @param type The type of coffee (e.g., Espresso, Latte).
     * @param size The size of the coffee (e.g., Small, Medium, Large).
     * @param price The price of the coffee.
     * @param roastLevel The roast level of the coffee (e.g., Light, Medium, Dark).
     * @param origin The origin of the coffee beans (e.g., Colombia, Ethiopia).
     * @param isDecaf Whether the coffee is decaffeinated.
     * @param stock The available stock of the coffee.
     * @param flavorNotes A list of flavor notes associated with the coffee.
     * @param brewMethod The method used to brew the coffee (e.g., Espresso, Drip, French Press).
     */
    public Coffee(int id, String name, String type, String size, double price, String roastLevel, String origin, boolean isDecaf, int stock, List<String> flavorNotes, String brewMethod) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
        this.roastLevel = roastLevel;
        this.origin = origin;
        this.isDecaf = isDecaf;
        this.stock = stock;
        this.flavorNotes = flavorNotes;
        this.brewMethod = brewMethod;
    }

    /**
     * Gets the ID of the coffee.
     *
     * @return The unique identifier of the coffee.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the coffee.
     *
     * @param id The unique identifier to set for the coffee.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the coffee.
     *
     * @return The name of the coffee.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the coffee.
     *
     * @param name The name to set for the coffee.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the type of the coffee.
     *
     * @return The type of the coffee (e.g., Espresso, Latte).
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the coffee.
     *
     * @param type The type to set for the coffee.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the size of the coffee.
     *
     * @return The size of the coffee (e.g., Small, Medium, Large).
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets the size of the coffee.
     *
     * @param size The size to set for the coffee.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Gets the price of the coffee.
     *
     * @return The price of the coffee.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the coffee.
     *
     * @param price The price to set for the coffee.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the roast level of the coffee.
     *
     * @return The roast level of the coffee (e.g., Light, Medium, Dark).
     */
    public String getRoastLevel() {
        return roastLevel;
    }

    /**
     * Sets the roast level of the coffee.
     *
     * @param roastLevel The roast level to set for the coffee.
     */
    public void setRoastLevel(String roastLevel) {
        this.roastLevel = roastLevel;
    }

    /**
     * Gets the origin of the coffee beans.
     *
     * @return The origin of the coffee beans (e.g., Colombia, Ethiopia).
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the origin of the coffee beans.
     *
     * @param origin The origin to set for the coffee beans.
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Checks whether the coffee is decaffeinated.
     *
     * @return True if the coffee is decaffeinated, false otherwise.
     */
    public boolean isDecaf() {
        return isDecaf;
    }

    /**
     * Sets whether the coffee is decaffeinated.
     *
     * @param isDecaf True if the coffee is decaffeinated, false otherwise.
     */
    public void setDecaf(boolean isDecaf) {
        this.isDecaf = isDecaf;
    }

    /**
     * Gets the stock level of the coffee.
     *
     * @return The available stock of the coffee.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the stock level of the coffee.
     *
     * @param stock The stock level to set for the coffee.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Gets the flavor notes of the coffee.
     *
     * @return A list of flavor notes associated with the coffee.
     */
    public List<String> getFlavorNotes() {
        return flavorNotes;
    }

    /**
     * Sets the flavor notes of the coffee.
     *
     * @param flavorNotes A list of flavor notes to set for the coffee.
     */
    public void setFlavorNotes(List<String> flavorNotes) {
        this.flavorNotes = flavorNotes;
    }

    /**
     * Gets the brew method used for the coffee.
     *
     * @return The method used to brew the coffee (e.g., Espresso, Drip, French Press).
     */
    public String getBrewMethod() {
        return brewMethod;
    }

    /**
     * Sets the brew method used for the coffee.
     *
     * @param brewMethod The brew method to set for the coffee.
     */
    public void setBrewMethod(String brewMethod) {
        this.brewMethod = brewMethod;
    }
}
