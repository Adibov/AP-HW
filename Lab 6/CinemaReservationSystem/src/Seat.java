public class Seat {
    private Row row;
    private int index;
    private boolean isReserved;
    private Person seatOwner;

    public Seat(Row row, int index, boolean isReserved) {
        this.row = row;
        this.index = index;
        this.isReserved = isReserved;
    }
}
