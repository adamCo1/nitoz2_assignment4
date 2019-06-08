package View;

import Event.*;
import Event.EventDetailsContainer;
import Event.JoinRequestContainer;

import java.util.List;

public class View implements IView {

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
        return null;
    }

    @Override
    public JoinRequestContainer getUserJoinRequest() {
        return null;
    }

    @Override
    public Event getEventToUpdateFromUser() {
        return null;
    }
}
