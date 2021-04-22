import com.google.gson.*;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.json.simple.*;
import org.json.simple.parser.*;

import java.util.Scanner;

public class Main {
    private static Inventory inventory = new Inventory();
    private static Basket basket = new Basket();
    private static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        addProducts();
        mainMenu();
    }

    /**
     * add defaults product to the inventory
     */
    public static void addProducts() {
        inventory.addProduct(new Product("Carrot", "Vegetables", 5, 20, "2020-3-15", "2021-3-15"), 10);
        inventory.addProduct(new Product("Apple", "Fruits", 10, 50, "2020-4-1", "2021-8-1"), 50);
        inventory.addProduct(new Product("12xEggs", "Egg", 100, 40, "2020-1-1", "2021-6-1"), 20);
        inventory.addProduct(new Product("Oats", "Grains", 70, 100, "2020-6-1", "2021-1-1"), 45);
        inventory.addProduct(new Product("Salmon", "Seafood", 150, 250, "2020-1-1", "2021-2-1"), 5);
        inventory.addProduct(new Product("Stake", "Meat", 800, 1000, "2020-3-1", "2021-9-1"), 5);
        inventory.addProduct(new Product("Milk", "Dairy", 100, 20, "2020-1-10", "2021-1-25"), 20);
        inventory.addProduct(new Product("Cheese", "Dairy", 150, 10, "2020-2-1", "2021-3-15"), 50);
    }

    /**
     * show main menu and get an option
     */
    public static void mainMenu() {
        System.out.println(); // empty line
        System.out.println("Choose an option:");
        System.out.println("1) add");
        System.out.println("2) remove");
        System.out.println("3) cart");
        System.out.println("4) products");
        System.out.println("5) checkout");
        int option = inputScanner.nextInt();
        if (option < 1 || option > 5) {
            System.out.println("Invalid input.");
            mainMenu();
            return;
        }

        if (option == 1)
            add();
        else if (option == 2)
            remove();
        else if (option == 3)
            cart();
        else if (option == 4)
            products();
        else
            checkout();
        mainMenu();
    }

    /**
     * add the chosen product to the basket
     */
    public static void add() {
        System.out.println(); // empty line
        if (inventory.getSize() == 0) {
            System.out.println("We are out of stock.");
            return;
        }
        products();
        System.out.println("Choose a Product:");
        int index = inputScanner.nextInt();
        if (index < 1 || index > inventory.getSize()) {
            System.out.println("Invalid input.");
            add();
            return;
        }
        Product product = inventory.getProduct(index);
        if (product == null) {
            add();
            return;
        }
        basket.addProduct(product);
        inventory.removeProduct(product, 1);
    }

    /**
     * remove the chosen product from the basket
     */
    public static void remove() {
        System.out.println(); // empty line
        cart();
        int index = inputScanner.nextInt();
        if (index < 1 || index > basket.getSize()) {
            System.out.println("Invalid input.");
            remove();
            return;
        }
        Product product = basket.getProduct(index);
        if (product == null) {
            remove();
            return;
        }
        basket.removeProduct(product);
        inventory.addProduct(product, 1);
    }

    /**
     * show basket's products
     */
    public static void cart() {
        System.out.println(); // empty line
        System.out.println(basket);
    }

    /**
     * show inventory products
     */
    public static void products() {
        System.out.println(); // empty line
        System.out.println(inventory);
    }


    public static void checkout() {
        System.out.println("It was a pleasure doing business with you.");
        System.exit(0);
    }
}
