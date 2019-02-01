package view;

public interface TicTacToeView {
    void setButtonText(int row, int col, String text);

    void showWinner(String winnigPlayerDisplayLabel);

    void clearWinnerDisplay();

    void clearButtons();
}
