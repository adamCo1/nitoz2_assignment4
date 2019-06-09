package View;

import Event.*;
import javafx.stage.Stage;

import java.util.List;
import java.util.Observer;

public interface IView {

    void setPrimaryStage(Stage primaryStage);
    EventDetailsContainer getEventUpdateFromUser() ;
    EventDetailsContainer getEventDetailsFromUser(String[] categories) ;
    JoinRequestContainer getUserJoinRequest();
    Event getEventToUpdateFromUser();
}
