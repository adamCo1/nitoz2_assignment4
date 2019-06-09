package Model;

import Event.*;
import Controller.Controller ;
import javafx.collections.ObservableList;

public interface IModel {

    void createEvent(Event event) ;
    void sendJoinRequest(JoinRequest joinRequest);
    void getUser(String username);
    Event getEvent(String name);
    void acceptJoinRequest(JoinRequest joinRequest,String accepterUsername);
    /**
     * this should give premissions and attach event to the force
     *
     */
    void addUpdate(EventUpdate update,Event event);
    ObservableList<String> getCatagories();
    void getContactSecurityUser(String securityForce);
    void setController(Controller controller);

}
