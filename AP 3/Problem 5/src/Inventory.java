import java.util.HashMap;

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
     */
    public void addProduct(Product newProduct) {
        if (!stock.containsKey(newProduct))
            stock.put(newProduct, 1);
        else
            stock.put(newProduct, stock.get(newProduct) + 1);
    }

    /**
     * remove the given product from the inventory
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
     * change product availability
     * @param product product
     * @param value new quantity
     */
    public void changeStock(Product product, int value) {
        if (!stock.containsKey(product))
            addProduct(product);
        stock.put(product, value);
        if (value == 0)
            stock.remove(product);
    }
}
