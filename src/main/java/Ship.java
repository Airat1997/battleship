public class Ship {
    private int row;
    private int col;
    private int length;
    private boolean isVertical;

    public Ship(int row, int col, int length, boolean isVertical) {
        this.row = row;
        this.col = col;
        this.length = length;
        this.isVertical = isVertical;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getLength() {
        return length;
    }

    public boolean isVertical() {
        return isVertical;
    }
}