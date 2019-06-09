package Model;

import Controller.Controller;
import Event.*;

import java.util.List;

public interface IModel {

    void createEvent(Event event) ;
    void sendJoinRequest(JoinRequest joinRequest);
    void getUser(String username);
    void getEvent(String name);
    void acceptJoinRequest(JoinRequest joinRequest,String accepterUsername);

    /**
     * this should give premissions and attach event to the force
     *
     */
    void addUpdate(EventUpdate update,Event event);
    List<String> getCatagories();
    void getContactSecurityUser(String securityForce);
    void setController(Controller controller);




}
