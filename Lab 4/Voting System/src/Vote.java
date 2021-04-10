import ir.huri.jcal.JalaliCalendar;

/**
 * Vote class to manage votes
 * @author Adibov
 * @version 1.0
 */
public class Vote {
    private final Person person;
    private final String date;

    /**
     * simple constructor to make a new object
     * @param person given person
     */
    public Vote(Person person) {
        this.person = person;
        date = new JalaliCalendar().toString();
    }

    /**
     * person getter
     * @return person
     */
    public Person getPerson() {
        return this.person;
    }

    /**
     * date getter
     * @return date
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Override equals method
     * @param o given objects
     * @return boolean compare
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Vote vote = (Vote)o;
            return this.person.getFirstName().equals(vote.getPerson().getFirstName()) && this.person.getLastName().equals(vote.getPerson().getLastName());
        } else {
            return false;
        }
    }
}
