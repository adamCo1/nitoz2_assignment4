package View;

import Controller.Controller;
import Event.*;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.util.Observer;

public interface IView extends Observer {

    void setPrimaryStage(Stage primaryStage);
    void getEventUpdateFromUser() ;
    void getEventDetailsFromUser(ObservableList<String> categories) ;
    void getUserJoinRequest();
    void setController(Controller controller) ;
    Event getEventToUpdateFromUser();
}
