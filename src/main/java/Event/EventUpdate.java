package Event;

public class EventUpdate {

    private String update;

    public EventUpdate(String update){
        this.update = update ;
    }

    public EventUpdate(EventUpdate other){
        this.update = other.update ;
    }


    public String getUpdate(){
        return this.update ;
    }
}
