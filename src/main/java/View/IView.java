package View;

import Controller.Controller;
import Event.*;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public interface IView {

    void setPrimaryStage(Stage primaryStage);
    void getEventUpdateFromUser() ;
    void getEventDetailsFromUser(ObservableList<String> categories) ;
    void getUserJoinRequest();
    void setController(Controller controller) ;
    Event getEventToUpdateFromUser();
}
