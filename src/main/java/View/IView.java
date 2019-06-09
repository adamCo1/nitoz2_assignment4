package View;

import Event.*;
import javafx.stage.Stage;

public interface IView {

    void setPrimaryStage(Stage primaryStage);
    void getEventUpdateFromUser() ;
    void getEventDetailsFromUser(String[] categories) ;
    void getUserJoinRequest();
    Event getEventToUpdateFromUser();
}
