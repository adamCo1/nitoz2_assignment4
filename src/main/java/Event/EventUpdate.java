package Event;

public class EventUpdate {

    private String update;
    private String creationTime;
    private String publisher;
    public EventUpdate(String update,String creationTime,String publisher){
        this.update = update ;
        this.publisher = publisher;
        this.creationTime = creationTime;
    }

    public EventUpdate(EventUpdate other){
        this.update = other.update ;
    }


    public String getCreationTime() {
        return creationTime;
    }

    public String getUpdate(){
        return this.update ;
    }

    public String getPublisher() {
        return publisher;
    }
}
