/**
 * Class Position
 * @author 25pandey
 * @version 5.24.23
 */
public class Position {
    private int row, col;

    /**
     * Constructor for class Position
     * @param row
     * @param col
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * getter for row
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * getter for col
     * @return col
     */
    public int getCol() {
        return col;
    }

    /**
     * setter for row
     * @return row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * setter for col
     * @return col
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * equals method for class Position
     * @param other
     * @return boolean for if the positions are equal
     */
    public boolean equals(Object other) {
        Position temp;
        if (other instanceof Position) {
            temp = (Position) other;
            return this.row == temp.row && this.col == temp.col;
        }
        return false;
    }
}
