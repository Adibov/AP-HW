public class FieldCard extends Card {
    private boolean isContinuous;

    /**
     * simple constructor
     * @param number card number
     * @param color card color
     */
    public FieldCard(int number, COLOR color, boolean isContinuous) {
        super(number, color);
        this.isContinuous = isContinuous;
    }

    /**
     * check if the dropped card is valid
     * @param droppedCard dropped card
     * @return boolean result
     */
    public boolean checkCardValidation(Card droppedCard) {
        if (isContinuous && number == 7)
            return droppedCard.number == 7;
        return droppedCard.number == 12 || droppedCard.number == number || droppedCard.color == color;
    }

    /**
     * isContinuous getter
     * @return isContinuous
     */
    public boolean isContinuous() {
        return isContinuous;
    }

    /**
     * isContinuous setter
     * @param continuous new value
     */
    public void setContinuous(boolean continuous) {
        isContinuous = continuous;
    }
}
