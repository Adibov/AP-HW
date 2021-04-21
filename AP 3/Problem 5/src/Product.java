import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public Product(String name, String category, double weight, double price, String manufacture, String expiration) {
        this.name = name;
        this.category = category;
        this.weight = weight;
        this.price = price;
        String[] mDate = manufacture.split("-");
        this.manufacture = LocalDate.of(Integer.parseInt(mDate[0]), Integer.parseInt(mDate[1]), Integer.parseInt(mDate[2]));
        String[] eDate = expiration.split("-");
        this.expiration = LocalDate.of(Integer.parseInt(eDate[0]), Integer.parseInt(eDate[1]), Integer.parseInt(eDate[2]));
    }

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
     * price getter
     * @return price
     */
    public double getPrice() {
        return price;
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

    @Override
    public String toString() {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", manufacture=" + manufacture.format(formatters) +
                ", expiration=" + expiration.format(formatters) +
                '}';
    }
}
