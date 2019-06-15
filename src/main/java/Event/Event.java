package Event;

import java.sql.Timestamp;
import java.util.LinkedList;

public class Event {

    private String eventTitle ;
    private LinkedList<EventUpdate> updateList ;
    private String creationTime;
    private String operator;
    private String incharge;
    private String status;
    private String handlingForce;
    private String catagory;

    public Event(String title, String creationTime, String operator, String incharge, String update, String handlingForce, String catagory,String status){
        this.eventTitle = title ;
        this.operator = operator;
        this.incharge = incharge;
        this.status = status;
        this.handlingForce = handlingForce;
        this.creationTime = creationTime;
//        this.open = open ;
        this.updateList = new LinkedList<EventUpdate>();
        this.catagory = catagory;
        this.updateList.add(new EventUpdate(update , creationTime , operator));
    }

    /**
     * add an update to this event . the updates are linked using linked list
     * @param update
     */
    public void addUpdateToEvent(EventUpdate update){
        this.updateList.add(update);
    }

//    public boolean getOpen(){
//        return this.open;
//    }


    public String getEventTitle() {
        return eventTitle;
    }

    public LinkedList<EventUpdate> getUpdateList() {
        return updateList;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public String getOperator() {
        return operator;
    }

    public String getIncharge() {
        return incharge;
    }

    public String getStatus() {
        return status;
    }

//    public boolean isOpen() {
//        return open;
//    }

//    public void setOpen(boolean open){
//        this.open = open ;
//    }

    public String getHandlingForce() {
        return handlingForce;
    }

    public String getUpdatesStrings(){
        if(this.updateList.size() == 0 )
            return "";
        String ans = "";
        int times = 0 ;

        for (EventUpdate update:
             updateList) {
            ans += update.toString() + ", ";
            times++;
        }

        if(times == 0)
            return "";

        return ans.substring(0,ans.length()-2);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventTitle='" + eventTitle + '\'' +
                ", updateList=" + updateList +
                ", creationTime='" + creationTime + '\'' +
                ", operator='" + operator + '\'' +
                ", incharge='" + incharge + '\'' +
                ", status='" + status + '\'' +
                ", handlingForce='" + handlingForce + '\'' +
                ", catagory=" + catagory +
                '}';
    }

    public String getCatagory() {
        return catagory;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
