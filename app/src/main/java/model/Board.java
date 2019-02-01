package model;

import static model.Player.O;
import static model.Player.X;

public class Board {
    private Cell[][] cells = new Cell[3][3];

    private Player winner;
    private Player currentTurn;
    private GameState gameState;

    private enum  GameState{ IN_PROGRESS, FINISHED }

    public Board() { restart();}


public void restart(){
    clearCells();
    winner = null;
    currentTurn = X;
    gameState =  GameState.IN_PROGRESS;

}

public Player mark(int row, int col){
       if(isValid(row, col)) {
           cells[row][col].setValue(currentTurn);

           if (isWinningMoveByPlayer(currentTurn, row, col)) {
               gameState = GameState.FINISHED;
               winner = currentTurn;
           } else {
               flipCurrentTurn();
           }
       }
    return winner;
}

    private void flipCurrentTurn() {
        currentTurn = currentTurn == X ? O: X;
    }

    private boolean isWinningMoveByPlayer(Player currentTurn, int row, int col) {
        return (cells[row][0].getValue() == currentTurn         // 3-in-the-row
                && cells[row][1].getValue() == currentTurn
                && cells[row][2].getValue() == currentTurn
                || cells[0][col].getValue() == currentTurn      // 3-in-the-column
                && cells[1][col].getValue() == currentTurn
                && cells[2][col].getValue() == currentTurn
                || row == col            // 3-in-the-diagonal
                && cells[0][0].getValue() == currentTurn
                && cells[1][1].getValue() == currentTurn
                && cells[2][2].getValue() == currentTurn
                || row + col == 2    // 3-in-the-opposite-diagonal
                && cells[0][2].getValue() == currentTurn
                && cells[1][1].getValue() == currentTurn
                && cells[2][0].getValue() == currentTurn);
    }

    public Player getWinner() {
        return winner;
    }
    private void clearCells(){
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                cells[i][j] = new Cell();
            }
        }
    }

    private boolean isValid(int row, int col){
        if(gameState == GameState.FINISHED){ return false;
        }
        else if(isOutOfBounds(row) || isOutOfBounds(col)){return false;}
        else if(cellValueAlreadySet(row,col)){return false;}
        else{return  true;}
    }

    private boolean cellValueAlreadySet(int row, int col) {
            return cells[row][col].getValue() != null;
    }

    private boolean isOutOfBounds(int row) {
        return row<0 || row>2;
    }

}