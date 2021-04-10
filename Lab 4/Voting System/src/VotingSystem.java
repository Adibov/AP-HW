import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * VotingSystem class to manage polls
 * @author Adibov
 * @version 1.0
 */
public class VotingSystem {
    private ArrayList<Voting> votingList;
    private final Scanner inputScanner;

    /**
     * simple construct to make a new object
     */
    public VotingSystem() {
        this.inputScanner = new Scanner(System.in);
        this.votingList = new ArrayList();
    }

    /**
     * create a poll with the given fields
     * @param question poll's question
     * @param type poll's type
     * @param polls votes
     */
    public void createVoting(String question, int type, ArrayList<String> polls) {
        Voting newVoting = new Voting(type, question, polls);
        this.votingList.add(newVoting);
    }

    /**
     * prints polls list
     */
    public void getVotingList() {
        int num = 1;

        for(Iterator var2 = this.votingList.iterator(); var2.hasNext(); ++num) {
            Voting voting = (Voting)var2.next();
            System.out.println("#" + num + ": " + voting.getQuestion());
        }

    }

    /**
     * show options for a question
     */
    public void getVoting() {
        System.out.println("Enter Question number:");
        getVotingList();
        int index = this.inputScanner.nextInt();
        this.inputScanner.nextLine();
        index--;
        if (index >= 0 && index < this.votingList.size()) {
            System.out.println("Question: " + ((Voting)this.votingList.get(index)).getQuestion());
            ((Voting)this.votingList.get(index)).getPolls();
        } else {
            System.out.println("Invalid input.");
            this.getVoting();
        }
    }

    /**
     * vote for a person in the given poll
     * @param index question index
     * @param person voter
     * @param votes options
     */
    public void vote(int index, Person person, ArrayList<String> votes) {
        if (index >= 1 && index <= this.votingList.size()) {
            ((Voting)this.votingList.get(index)).vote(person, votes);
        } else {
            System.out.println("Invalid index.");
        }
    }

    /**
     * prints results
     * @param index question index
     */
    public void getResult(int index) {
        if (index >= 1 && index <= this.votingList.size()) {
            System.out.println();
            System.out.println("Result");
            ((Voting)this.votingList.get(index - 1)).printVotes();
        } else {
            System.out.println();
            System.out.println("Invalid index.");
        }
    }

    /**
     * get question by index
     * @param index question index
     * @return question
     */
    public Voting getQuestionByIndex(int index) {
        index--;
        if (index < 0 || index >= votingList.size())
            return null;
        return votingList.get(index);
    }

    /**
     * returns questions number
     * @return questions number
     */
    public int getVotingListSize() {
        return votingList.size();
    }
}