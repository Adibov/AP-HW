/**
 * Person class to identity users
 * @author Adibov
 * @version 1.0
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     * simple constructor to make a new Person instance
     * @param firstName person's firstname
     * @param lastName person's lastname
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * firstname getter
     * @return firstname
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * lastname getter
     * @return lastname
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * override toString method
     * @return String
     */
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
