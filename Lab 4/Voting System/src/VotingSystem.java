import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class VotingSystem {
    private ArrayList<Voting> votingList;
    private final Scanner inputScanner;

    public VotingSystem() {
        this.inputScanner = new Scanner(System.in);
        this.votingList = new ArrayList();
    }

    public void createVoting(String question, int type, ArrayList<String> polls) {
        Voting newVoting = new Voting(type, question, polls);
        this.votingList.add(newVoting);
    }

    public void getVotingList() {
        int num = 1;

        for(Iterator var2 = this.votingList.iterator(); var2.hasNext(); ++num) {
            Voting voting = (Voting)var2.next();
            System.out.println("#" + num + ": " + voting.getQuestion());
        }

    }

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

    public void vote(int index, Person person, ArrayList<String> votes) {
        if (index >= 1 && index <= this.votingList.size()) {
            ((Voting)this.votingList.get(index)).vote(person, votes);
        } else {
            System.out.println("Invalid index.");
        }
    }

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

    public Voting getQuestionByIndex(int index) {
        index--;
        if (index < 0 || index >= votingList.size())
            return null;
        return votingList.get(index);
    }

    public int getVotingListSize() {
        return votingList.size();
    }
}