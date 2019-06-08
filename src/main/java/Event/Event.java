package Event;

import java.util.LinkedList;

public class Event {

    private String eventTitle ;
    private LinkedList<EventUpdate> updateList ;
    private boolean open ;

    public Event(EventUpdate eventUpdate , String eventTitle){
        this.eventTitle = eventTitle ;
        this.open = false ;
        this.updateList = new LinkedList<EventUpdate>();
        this.updateList.add(eventUpdate);
    }

    /**
     * add an update to this event . the updates are linked using linked list
     * @param update
     */
    public void addUpdateToEvent(EventUpdate update){
        this.updateList.add(update);
    }

    public boolean getOpen(){
        return this.open;
    }

    public void setOpen(boolean open){
        this.open = open ;
    }
}
