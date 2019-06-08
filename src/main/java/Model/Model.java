package Model;

import Event.*;
import java.util.List;

public class Model implements IModel {
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
}
