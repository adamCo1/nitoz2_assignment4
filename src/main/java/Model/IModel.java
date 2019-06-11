package Model;

import Controller.Controller;
import Event.*;
import javafx.collections.ObservableList;
import javafx.util.Pair;

import java.util.List;

public interface IModel {

    void createEvent(Event event) ;
    void sendJoinRequest(JoinRequest joinRequest);
    User getUser(String username);
    ObservableList<Event> getEventsByCatagory(String name);
    ObservableList<Event> getEventByTitle(String name);
    ObservableList<Event> getEventsByForce(String name);

    void acceptJoinRequest(JoinRequest joinRequest);

    /**
     * this should give premissions and attach event to the force
     *
     */
    void addUpdate(EventUpdate update,Event event);
    List<String> getCatagories();
    User getContactSecurityUser(String securityForce);
    void setController(Controller controller);
    Pair<ObservableList<Event>,User> login(String name);




}
