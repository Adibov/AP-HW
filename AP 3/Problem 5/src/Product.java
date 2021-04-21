import java.time.LocalDate;
import java.util.Objects;

/**
 * Product class to implement products
 * @author Adibov
 * @version 1.0
 */
public class Product {
    final private String name, category;
    private double weight, price;
    final private LocalDate manufacture, expiration;

    /**
     * Product class constructor to make a new object
     * @param name product name
     * @param category product category
     * @param weight product weight
     * @param price product price
     * @param expirationDays number of days last for product to be expired
     */
    public Product(String name, String category, double weight, double price, int expirationDays) {
        this.name = name;
        this.category = category;
        this.weight = weight;
        this.price = price;
        this.manufacture = LocalDate.now();
        this.expiration = manufacture.plusDays(expirationDays);
    }

    /**
     * Override equals method
     * @param o compared object
     * @return boolean result
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) && category.equals(product.category);
    }
}
