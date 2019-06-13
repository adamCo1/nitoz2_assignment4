package Controller;

import Event.*;
import Interfaces.ObserveableObject;
import Model.IModel;
import Model.Model;
import Objects.StageHolder;
import View.IView;
import View.View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    private IModel model ;
    private IView view ;


    public Controller(){
        this.model = new Model() ;
        this.view = new View() ;
        this.view.setController(this);
        this.model.setController(this);
        this.model.attachObserver(view);
    }

    /**
     *
     */
    public void createNewEvent(){
        List<String> allCategories = model.getCatagories() ;
        view.getEventDetailsFromUser(FXCollections.observableArrayList(allCategories)) ;
    }

    public void updateEvent(){
        view.getEventUpdateFromUser();
    }

    /**
     * join force UC
     */
    public void joinForceToEvent(){
        view.getUserJoinRequest();

    }

    public ObservableList<Event> getEvent(String title , String value){
        return model.getEvent(title,value);
    }

    void setPrimaryStage(){
        view.setPrimaryStage(StageHolder.getInstance().getStage());
    }

    public void addEventToDB(Event event){
        this.model.createEvent(event);
    }

//    public Event getEventFromDB(String title){
//        return model.getEvent(title);
//    }

    public void addEventUpdateToDB(EventUpdate update , Event event){
        this.model.addUpdate(update , event);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
