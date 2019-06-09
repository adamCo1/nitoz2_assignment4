package Model;

import Event.*;
import Interfaces.ObserveableObject;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable implements IModel , ObserveableObject {
    /**
     * get listed categories in the system for the operator to choose from
     * @return list of all categories from db
     */
    @Override
    public List<String> getAllPossibleCategories() {
        return null;
    }

    /**
     * add a new event to the system
     * @param event
     */
    @Override
    public void addEventToSystem(Event event) {

    }

    @Override
    public void pushJoinRequestToEvent(JoinRequestContainer joinRequest) {

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
