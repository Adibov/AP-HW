import java.util.HashMap;

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

    @Override
    public String toString() {
        String result = "Basket{";
        for (Product product : stock.keySet()) {
            result += product.toString();
            result += ": " + stock.get(product);
        }
        result += '}';
        return result;
    }
}