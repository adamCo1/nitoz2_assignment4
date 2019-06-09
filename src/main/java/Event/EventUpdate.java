package Event;

public class EventUpdate {

    private String update , category;

    public EventUpdate(String update , String category){
        this.update = update ;
        this.category = category ;
    }

    public EventUpdate(EventUpdate other){
        this.category = other.category ;
        this.update = other.update ;
    }


    public String getCategory(){
        return this.category ;
    }

    public String getUpdate(){
        return this.update ;
    }
}
