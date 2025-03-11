package com.jumong.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Controller
public class HomeController {

	// List to store the coffee objects
	private List<Coffee> coffeeList = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(HomeController.class, args);
	}

	/**
	 * Constructor that initializes a list of coffee objects with predefined values.
	 */
	public HomeController() {
		coffeeList.add(new Coffee(1, "Espresso", "Arabica", "Small", 3.50, "Dark", "Ethiopia", false, 10, Arrays.asList("Chocolate", "Nutty"), "Espresso"));
		coffeeList.add(new Coffee(2, "Latte", "Arabica", "Medium", 4.50, "Medium", "Brazil", false, 8, Arrays.asList("Creamy", "Sweet"), "Drip"));
		coffeeList.add(new Coffee(3, "Cappuccino", "Robusta", "Large", 5.00, "Medium", "Colombia", false, 12, Arrays.asList("Fruity", "Bold"), "French Press"));
		coffeeList.add(new Coffee(4, "Mocha", "Arabica", "Medium", 4.75, "Dark", "Guatemala", false, 6, Arrays.asList("Chocolate", "Smooth"), "Espresso"));
		coffeeList.add(new Coffee(5, "Americano", "Robusta", "Large", 3.25, "Light", "Kenya", false, 15, Arrays.asList("Citrus", "Balanced"), "Drip"));;
	}

	/**
	 * Handles GET requests to the root URL ("/").
	 * Displays the list of coffees to the user.
	 *
	 * @param model the model to pass data to the view
	 * @return the name of the view template to render
	 */
	@GetMapping("/")
	public String getCoffees(Model model) {
		model.addAttribute("coffees", coffeeList);
		return "index";
	}

	/**
	 * Handles GET requests to the "/delete" URL.
	 * Removes a coffee from the list by its ID.
	 *
	 * @param id the ID of the coffee to delete
	 * @return a redirect to the root URL ("/")
	 */
	@GetMapping("/delete")
	public String deleteCoffee(@RequestParam int id) {
		coffeeList.removeIf(coffee -> coffee.getId() == id);
		return "redirect:/";
	}

	/**
	 * Handles GET requests to the "/add" URL.
	 * Displays the form to add a new coffee.
	 *
	 * @return the name of the view template to render for adding a coffee
	 */
	@GetMapping("/add")
	public String add() {
		return "new";
	}

	/**
	 * Handles POST requests to the "/save" URL.
	 * Saves a new coffee to the coffee list.
	 *
	 * @param name        the name of the coffee
	 * @param type        the type of the coffee bean
	 * @param size        the size of the coffee
	 * @param price       the price of the coffee
	 * @param roastLevel  the roast level of the coffee
	 * @param origin      the origin of the coffee beans
	 * @param isDecaf     whether the coffee is decaffeinated
	 * @param stock       the available stock for the coffee
	 * @param flavorNotes the flavor notes of the coffee
	 * @param brewMethod  the brew method for making the coffee
	 * @return a redirect to the root URL ("/") after saving the coffee
	 */
	@PostMapping("/save")
	public String save(@RequestParam String name,
					   @RequestParam String type,
					   @RequestParam String size,
					   @RequestParam double price,
					   @RequestParam String roastLevel,
					   @RequestParam String origin,
					   @RequestParam(required = false) boolean isDecaf,
					   @RequestParam int stock,
					   @RequestParam List<String> flavorNotes,
					   @RequestParam String brewMethod) {
		Coffee c = new Coffee();
		c.setId(coffeeList.size() + 1);
		c.setName(name);
		c.setType(type);
		c.setSize(size);
		c.setPrice(price);
		c.setRoastLevel(roastLevel);
		c.setOrigin(origin);
		c.setDecaf(isDecaf);
		c.setStock(stock);
		c.setFlavorNotes(flavorNotes);
		c.setBrewMethod(brewMethod);
		coffeeList.add(c);
		return "redirect:/";
	}

	/**
	 * Handles GET requests to the "/edit" URL.
	 * Displays the form to edit an existing coffee.
	 *
	 * @param id    the ID of the coffee to edit
	 * @param model the model to pass data to the view
	 * @return the name of the view template to render for editing the coffee
	 */
	@GetMapping("/edit")
	public String edit(@RequestParam int id, Model model) {
		for (Coffee coffee : coffeeList) {
			if (coffee.getId() == id) {
				model.addAttribute("coffee", coffee);
				return "edit";
			}
		}
		return "redirect:/";
	}

	/**
	 * Handles POST requests to the "/update" URL.
	 * Updates an existing coffee's details.
	 *
	 * @param id          the ID of the coffee to update
	 * @param name        the name of the coffee
	 * @param type        the type of the coffee bean
	 * @param size        the size of the coffee
	 * @param price       the price of the coffee
	 * @param roastLevel  the roast level of the coffee
	 * @param origin      the origin of the coffee beans
	 * @param isDecaf     whether the coffee is decaffeinated
	 * @param stock       the available stock for the coffee
	 * @param flavorNotes the flavor notes of the coffee
	 * @param brewMethod  the brew method for making the coffee
	 * @return a redirect to the root URL ("/") after updating the coffee
	 */
	@PostMapping("/update")
	public String update(@RequestParam int id,
						 @RequestParam String name,
						 @RequestParam String type,
						 @RequestParam String size,
						 @RequestParam double price,
						 @RequestParam String roastLevel,
						 @RequestParam String origin,
						 @RequestParam(name = "isDecaf", required = false, defaultValue = "false") boolean isDecaf,
						 @RequestParam int stock,
						 @RequestParam String flavorNotes,  // single string of comma-separated values
						 @RequestParam String brewMethod) {

		// Find the coffee by ID and update its details
		for (Coffee coffee : coffeeList) {
			if (coffee.getId() == id) {
				coffee.setName(name);
				coffee.setType(type);
				coffee.setSize(size);
				coffee.setPrice(price);
				coffee.setRoastLevel(roastLevel);
				coffee.setOrigin(origin);
				coffee.setDecaf(isDecaf);
				coffee.setStock(stock);

				// Split the flavorNotes string into a list and trim each note to remove extra spaces
				List<String> updatedFlavorNotes = Arrays.asList(flavorNotes.split("\\s*,\\s*")); // Regular expression to handle optional spaces after commas
				coffee.setFlavorNotes(updatedFlavorNotes);

				coffee.setBrewMethod(brewMethod);
				break;
			}
		}
		return "redirect:/";
	}
}