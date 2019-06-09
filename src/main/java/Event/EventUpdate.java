package Event;

public class EventUpdate {

    private String update , category;
    private String creationTime;

    public EventUpdate(String update,String creationTime){
        this.update = update ;
        this.category = category ;
        this.creationTime = creationTime;
    }

    public EventUpdate(EventUpdate other){
        this.category = other.category ;
        this.update = other.update ;
    }


    public String getCreationTime() {
        return creationTime;
    }

    public String getUpdate(){
        return this.update ;
    }
}
