package View;

import Event.*;
import Event.EventDetailsContainer;
import Event.JoinRequestContainer;
import Interfaces.ObserveableObject;
import javafx.beans.InvalidationListener;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class View extends Observable implements IView , ObserveableObject {

    public View(){

    }

    @Override
    public EventDetailsContainer getEventUpdateFromUser() {
        return null;
    }

    /**
     * show a form for the operator to fill the events details
     * @return EventDetailsContainer object which holds the details of the event
     */
    @Override
    public EventDetailsContainer getEventDetailsFromUser(List<String> categories) {

        /**
         * show the create new event window . change controller when all loaded successfully
         */
        return null;
    }

    @Override
    public JoinRequestContainer getUserJoinRequest() {
        /**
         * show the join forces window . change controller when all loaded successfully
         */

        return null;
    }

    @Override
    public Event getEventToUpdateFromUser() {

        /**
         * show the update event window . change controller when all loaded successfully
         */

        return null;
    }

    @Override
    public void attachObserver(Observer o) {
        addObserver(o);
    }

    @Override
    public void removeObserver(Observer o) {
        deleteObserver(o);
    }


}
