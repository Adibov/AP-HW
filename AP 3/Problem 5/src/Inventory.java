import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Inventory class to implement stock
 * @author Adibov
 * @version 1.0
 */
public class Inventory {
    final private HashMap<Product, Integer> stock;

    /**
     * simple constructor to make a new object
     */
    public Inventory() {
        stock = new HashMap<Product, Integer>();
    }

    /**
     * add the given product to the inventory
     * @param newProduct new Product
     * @param value product quantity
     */
    public void addProduct(Product newProduct, int value) {
        if (!stock.containsKey(newProduct))
            stock.put(newProduct, 0);
        stock.put(newProduct, stock.get(newProduct) + value);
    }

    /**
     * remove the given product from the inventory
     * @param product new Product
     * @param value product quantity
     */
    public void removeProduct(Product product, int value) {
        if (!stock.containsKey(product))
            System.out.println("No such product.");
        else if (stock.get(product) < value)
            System.out.println("Not enough product.");
        else {
            stock.put(product, stock.get(product) - value);
            if (stock.get(product) == 0)
                stock.remove(product);
        }
    }

    /**
     * change product availability
     * @param product product
     * @param value new quantity
     */
    public void changeStock(Product product, int value) {
        if (!stock.containsKey(product))
            addProduct(product, value);
        stock.put(product, value);
        if (value == 0)
            stock.remove(product);
    }

    /**
     * get stock's size
     * @return stock's size
     */
    public int getSize() {
        return stock.size();
    }

    /**
     * return product with the given index
     * @param index given index
     * @return result product
     */
    public Product getProduct(int index) {
        for (Product product : stock.keySet()) {
            index--;
            if (index == 0)
                return product;
        }
        return null;
    }

    /**
     * override toString method
     * @return String result
     */
    @Override
    public String toString() {
        int index = 1;
        String result = "Inventory:\n";
        for (Product product : stock.keySet()) {
            result += (index + ")");
            JSONObject json = new JSONObject();
            json.put("Product", product);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JSONParser parser = new JSONParser();
            try {
                json = (JSONObject) parser.parse(json.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String prettyJsonString = gson.toJson(json);
            result += prettyJsonString;
            result += ("instock: " + stock.get(product) + "\n");
            index++;
        }
        return result;
    }
}