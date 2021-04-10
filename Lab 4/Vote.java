public class Vote {
    private final Person person;
    private final String date;

    public Vote(Person person) {
        this.person = person;
        this.date = "1400";
    }

    public Person getPerson() {
        return this.person;
    }

    public String getDate() {
        return this.date;
    }

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