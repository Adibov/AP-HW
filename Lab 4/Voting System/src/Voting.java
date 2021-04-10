import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Voting class to implement poll
 * @author Adibov
 * @version 1.0
 */
public class Voting {
    private final int type;
    private final String question;
    private ArrayList<Person> voters;
    private HashMap<String, HashSet<Vote>> polls;

    /**
     * simple constructor to make a new objects
     * @param type poll type
     * @param question poll question
     */
    public Voting(int type, String question) {
        this.type = type;
        this.question = question;
        this.voters = new ArrayList();
        this.polls = new HashMap();
    }

    /**
     * simple constructor to make a new objects
     * @param type poll type
     * @param question poll question
     * @param pollsList options list
     */
    public Voting(int type, String question, ArrayList<String> pollsList) {
        this.type = type;
        this.question = question;
        this.voters = new ArrayList();
        this.polls = new HashMap();
        Iterator var4 = pollsList.iterator();

        while(var4.hasNext()) {
            String poll = (String)var4.next();
            this.polls.put(poll, new HashSet());
        }

    }

    /**
     * question getter
     * @return question
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * create a new poll
     * @param option poll's option
     */
    public void createPoll(String option) {
        this.polls.put(option, new HashSet());
    }

    /**
     * vote for the given fields
     * @param person voter
     * @param votes person's votes
     */
    public void vote(Person person, ArrayList<String> votes) {
        if (votes.size() > 1 && this.type == 0) {
            System.out.println("Number of votes doesn't match voting type.");
        } else if (voters.contains(person)) {
            System.out.println("This user has had voted before.");
        } else {
            Iterator var3 = votes.iterator();

            String vote;
            while(var3.hasNext()) {
                vote = (String)var3.next();
                if (!this.polls.containsKey(vote)) {
                    System.out.println("No such option found.");
                    return;
                }
            }

            var3 = votes.iterator();

            while(var3.hasNext()) {
                vote = (String)var3.next();
                ((HashSet)this.polls.get(vote)).add(new Vote(person));
            }

            this.voters.add(person);
        }
    }

    /**
     * voters getter
     */
    public void getVoters() {
        Iterator var1 = this.voters.iterator();

        while(var1.hasNext()) {
            Person voter = (Person)var1.next();
            voter.toString();
        }

    }

    /**
     * prints voters
     */
    public void printVotes() {
        System.out.println();
        System.out.println("Question: " + question);
        for (String i : polls.keySet())
            System.out.println(i + ": " + polls.get(i).size());
    }

    /**
     * prints questions
     */
    public void getPolls() {
        int num = 1;
        for(Iterator var2 = this.polls.keySet().iterator(); var2.hasNext(); ++num) {
            String poll = (String)var2.next();
            System.out.println("#" + num + ": " + poll);
        }

    }

    /**
     * get polls size
     * @return polls size
     */
    public int getPollsSize() {
        return polls.size();
    }

    /**
     * get poll by index
     * @param index poll's index
     * @return poll
     */
    public String getPollByIndex(int index) {
        for (String i : polls.keySet()) {
            index--;
            if (index == 0)
                return i;
        }
        return null;
    }
}