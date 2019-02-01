package presenter;

public interface Presenter {


  void onCreate();
  void onPause();
  void onResume();
  void onDestroy();
  void OnButtonSelected(int row, int col);
  void OnResetSelected();

}
