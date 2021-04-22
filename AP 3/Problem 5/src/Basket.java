import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Basket {
    final private HashMap<Product, Integer> stock;

    /**
     * simple constructor to make a new object
     */
    public Basket() {
        stock = new HashMap<Product, Integer>();
    }

    /**
     * add the given product to the basket
     * @param newProduct new Product
     */
    public void addProduct(Product newProduct) {
        if (!stock.containsKey(newProduct))
            stock.put(newProduct, 1);
        else
            stock.put(newProduct, stock.get(newProduct) + 1);
    }

    /**
     * remove the given product from the basket
     * @param product new Product
     */
    public void removeProduct(Product product) {
        if (!stock.containsKey(product))
            System.out.println("No such product");
        else {
            stock.put(product, stock.get(product) - 1);
            if (stock.get(product) == 0)
                stock.remove(product);
        }
    }

    /**
     * calculate total product price of the basket
     * @return total price
     */
    public double totalPrice() {
        double result = 0;
        for (Product product : stock.keySet())
            result += product.getPrice() * stock.get(product);
        return result;
    }

    /**
     * return stock's size
     * @return stock's size
     */
    public int getSize() {
        return stock.size();
    }

    /**
     * return Product with the given index
     * @param index the given index
     * @return result Product
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
     * Override toString method
     * @return String result
     */
    @Override
    public String toString() {
        int index = 1;
        String result = "Itemsincart:\n";
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