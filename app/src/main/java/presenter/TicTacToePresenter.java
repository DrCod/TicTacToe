package presenter;

import android.text.TextUtils;

import model.Board;
import model.Player;
import presenter.Presenter;
import view.TicTacToeView;

public class TicTacToePresenter implements Presenter {

    TicTacToeView view;
    Board model;

    public TicTacToePresenter(TicTacToeView v){
        this.view =v;
        this.model = new Board();
    }


    public  void onCreate(){model = new Board();}
    public void onPause(){}
    public void onResume(){}
    public void onDestroy(){}

    @Override
    public void OnButtonSelected(int row, int col) {
        
        Player playerThatMoved = model.mark(row,col);

        if(playerThatMoved != null){
            view.setButtonText(row,col,playerThatMoved.toString());
            if(model.getWinner != null){
                view.showWinner(playerThatMoved.toString());
            }
        }


    }

    @Override
    public void OnResetSelected() {
        view.clearButtons();
        view.clearWinnerDisplay();
        model.restart();
    }


}
