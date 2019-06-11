package Controller;

import Event.*;
import Interfaces.ObserveableObject;
import Model.IModel;
import Model.Model;
import Objects.StageHolder;
import View.IView;
import View.View;
import javafx.collections.ObservableList;
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


    }

    /**
     *
     */
    public void createNewEvent(){
        //ObservableList<String> allCategories = model.getCatagories() ;
        //view.getEventDetailsFromUser(allCategories) ;
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
