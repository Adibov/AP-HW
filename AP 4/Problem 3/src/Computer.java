public class Computer extends Player {
    /**
     * simple constructor
     * @param name computer name
     */
    public Computer(String name) {
        super("Computer #" + name);
    }

    /**
     * advance a turn
     * @param fieldCard field card
     * @return dropped card
     */
    @Override
    public Card advanceTurn(FieldCard fieldCard) {
        if (fieldCard.isContinuous() && fieldCard.getNumber() == 7) {
            for (Card card : cards)
                if (card.getNumber() == 7 && fieldCard.checkCardValidation(card))
                    return card;
            return null;
        }

        for (Card card : cards)
            if (card.getNumber() == 8 && fieldCard.checkCardValidation(card))
                return card;
        for (Card card : cards)
            if (fieldCard.checkCardValidation(card))
                return card;
        return null;
    }
}
