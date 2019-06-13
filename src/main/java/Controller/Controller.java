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
    private User connectedUser , userA , userB ;

    public Controller(){
        this.model = new Model() ;
        this.view = new View() ;
        this.view.setController(this);
        this.model.setController(this);
        this.model.attachObserver(view);
        ((Model)model).createUser("fireman_a","fire",7);
        ((Model)model).createUser("operator_a","operator",10);
        this.userA = new User("fireman_a","fire",7);
        this.userB = new User("operator_a","operator",10);
        this.connectedUser = userB ;
    }

    public boolean checkWritePermission(Event eventToUpdate){
        return true;
    }

    public ObservableList<User> getUsersByForce(String type){
        return model.getUsersByForce(type) ;
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

    public void switchUsers(){
        if(connectedUser.equals(userA)) {
            connectedUser = userB;
            System.out.println(userB.getUsername() + " now connected");
        }else {
            connectedUser = userA;
            System.out.println(userA.getUsername() + " now connected");
        }

        return;
    }

    public User getConnectedUser(){
        return this.connectedUser ;
    }
}
