package Event;

public class EventDetailsContainer {

    private String title , category;
    private EventUpdate update ;

    public EventDetailsContainer(String title , EventUpdate update , String catrgory){
        this.update = update ;
        this.title = title ;
        this.category = catrgory ;
    }

    public String getTitle(){
        return this.title ;
    }

    public EventUpdate getUpdate(){
        return this.update ;
    }

    public String getCategory(){
        return this.category ;
    }
}
