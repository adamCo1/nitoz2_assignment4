package Model;

import Controller.Controller;
import Event.*;
import javafx.collections.ObservableList;
import javafx.util.converter.TimeStringConverter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Observer;

public interface IModel {

    Timestamp getTimeStamp();
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
    ObservableList<Event> getEvent(String field,String value);
    void addUpdate(EventUpdate update,Event event);
    void createCatagory(String category);
    List<String> getCatagories();
    User getContactSecurityUser(String securityForce);
    void setController(Controller controller);
    List<ObservableList> getJoinRequests(String username);
    boolean checkWritePremission(User u,Event e);
    ObservableList<JoinRequest> getNotifications(String username);
    void attachObserver(Observer o) ;
    void removeObserver(Observer o);
    ObservableList<User> getUsersByForce(String force);
}
