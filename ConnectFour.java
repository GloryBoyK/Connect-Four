/**
 * Class ConnectFour
 * @author 25pandey
 * @version 5.25.2023
 */
public class ConnectFour implements BoardGame{

    // game board for playing ConnectFour
    private int[][] board;
    private int currentPlayer;
    private Position[] winningPositions;

    /**
     * Constructor for class ConnectFour
     */
    public ConnectFour()    {
        newGame();
    }

    /**
     * Prepares the board for a new game.
     */
    @Override
    public void newGame() {
        System.out.println("setting new game");
        board =  new int[6][7];
        currentPlayer = 1;
        winningPositions = new Position[4];
    }

    private boolean horizontalWin() {
        for(int i=0; i<3; i++){
            for(int j=0; j<7; j++){
                if(board[i][j] == board[i+1][j] && board[i+1][j] == board[i+2][j] && board[i+2][j] == board[i+3][j] && board[i][j] != 0){
                    winningPositions[0] = new Position(i+3, j);
                    winningPositions[1] = new Position(i+2, j);
                    winningPositions[2] = new Position(i+1, j);
                    winningPositions[3] = new Position(i, j);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verticalWin(){
        for(int i=0; i<6; i++){
            for(int j=0; j<4; j++){
                if(board[i][j] == board[i][j+1] && board[i][j+1] == board[i][j+2] && board[i][j+2] == board[i][j+3] && board[i][j] != 0){
                    winningPositions[0] = new Position(i, j);
                    winningPositions[1] = new Position(i, j+1);
                    winningPositions[2] = new Position(i, j+2);
                    winningPositions[3] = new Position(i, j+3);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean diagonalWinL(){
        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                if(board[i+3][j] == board[i+2][j+1] && board[i+2][j+1] == board[i+1][j+2] && board[i+1][j+2] == board[i][j+3] && board[i+3][j] != 0){
                    winningPositions[0] = new Position(i+3, j);
                    winningPositions[1] = new Position(i+2, j+1);
                    winningPositions[2] = new Position(i+1, j+2);
                    winningPositions[3] = new Position(i, j+3);
                    return true;
                }
            }
        }
        return false;
    }
    private boolean diagonalWinR(){
        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                if(board[i][j] == board[i+1][j+1] && board[i+1][j+1] == board[i+2][j+2] && board[i+2][j+2] == board[i+3][j+3] && board[i][j] != 0){
                    winningPositions[3] = new Position(i, j);
                    winningPositions[2] = new Position(i+1, j+1);
                    winningPositions[1] = new Position(i+2, j+2);
                    winningPositions[0] = new Position(i+3, j+3);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Is the game over?
     * @return true if the game is over, false otherwise
     */
    @Override
    public boolean gameOver() {
        return horizontalWin() || verticalWin() || diagonalWinL() || diagonalWinR();
    }

    private boolean isFull(){
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                if(board[i][j]==0)
                    return false;
            }
        }
        return true;
    }

    /**
     * Who is the winner?
     * @return 0 if there is no winner, 1 if the first player is a winner, 2 if the second player is a winner.
     */
    @Override
    public int getWinner() {
        if(isFull())
            return 0;
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                if(board[i][j]==0)
                    continue;
                else
                    return 3-currentPlayer;
            }
        }
        return 0;
    }

    /**
     * Where are the tokens that determine who the winner is?
     * @return the locations of the pieces that determine the game winner.
     */
    @Override
    public Position[] getWinningPositions() {
        return winningPositions;
    }

    /**
     * Does the column have room for an additional move?
     * @param column the column number
     * @return false if there is room for another move in the column, true if not.
     */
    @Override
    public boolean columnFull(int column) {
        System.out.println(board[0][column]);
        return board[0][column] !=0 ;
    }

    /**
     * Change the game to reflect the current player placing a piece in the column.
     * @param column the column number
     */
    @Override
    public void play(int column) {
        if(!columnFull(column)){
            for(int r=5; r>=0; r--){
                if(board[r][column]==0){
                    board[r][column] = currentPlayer;
                    currentPlayer = (currentPlayer == 1) ? 2 : 1;
                    System.out.println(currentPlayer+" "+r+", "+column);
                    return;
                }
            }
        }
    }

    /**
     * What is the current board configuration?
     * @return for each cell on the board grid:
     *   0 if it is not filled,
     *   1 if it is filled by the first player's piece,
     *   2 if it is filled by the second player's piece.
     */
    @Override
    public int[][] getBoard() {
        return board;
    }

    /**
     * getter for currentplayer
     * @return currentPlayer
     */
    public int getCurrentPlayer(){
        return currentPlayer;
    }
}
