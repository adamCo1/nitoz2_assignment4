package Controller;

import Event.*;
import Model.IModel;
import Model.Model;
import Objects.ErrorBox;
import Objects.StageHolder;
import View.IView;
import View.View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    private IModel model ;
    private IView view ;
    private User connectedUser ;

    public Controller(){
        this.model = new Model() ;
        this.view = new View() ;
        this.view.setController(this);
        this.model.setController(this);
        this.model.attachObserver(view);
        ((Model)model).createUser("adam","fire",10);
        ((Model)model).createUser("yuval","fire",10);

       // initUsersAndEvents();

    }

    public List getJoinRequests(){
        return model.getJoinRequests(connectedUser.getUsername());
    }


    public void initUsersAndEvents(){
        User operator = new User("admin","operators",10);
        User policeOperator = new User("policeContact","police",7);
        User policeOfficer  = new User("policeOfficer","police",10);
        String catagory = "shooting";
        ((Model)model).createUser(operator.getUsername(),operator.getForce(),operator.getRank());
        ((Model)model).createUser(policeOfficer.getUsername(),policeOfficer.getForce(),policeOfficer.getRank());
        ((Model)model).createUser(policeOperator.getUsername(),policeOperator.getForce(),policeOperator.getRank());
        Event e = new Event("shootingAtHarlem","timestmp","admin","none","UPDATE 1","none" ,"shooting","open");
        Event e1 = new Event("ShootingAtDaled" , getTimeStamp() , "admin","none","UPDATE 1" , "none" , "shooting","open");
        model.createCatagory(catagory);
        model.createEvent(e);
        model.createEvent(e1);
    }


    public String getTimeStamp(){
        Timestamp time = model.getTimeStamp();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(time);
        return timeStamp;
    }

    public void sendJoinRequest(JoinRequest joinRequest){
        this.model.sendJoinRequest(joinRequest);
    }

    public boolean checkWritePermission(Event eventToUpdate){

        if(connectedUser == null)
            return false ;

        return model.checkWritePremission(connectedUser,eventToUpdate);
    }

    public ObservableList<User> getUsersByForce(String type){
        return model.getUsersByForce(type) ;
    }

    /**
     *
     */
    public void createNewEvent(){
        if(connectedUser == null){
            ErrorBox box = new ErrorBox();
            box.showErrorStage("Log in first");
            return;
        }
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

        if(connectedUser == null){
            ErrorBox box = new ErrorBox();
            box.showErrorStage("login first");
            return;
        }

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

    public void login(){
        view.login();
    }

    public void loginFromDB(String username){
        connectedUser = model.getUser(username) ;

    }

    public void userEvents() {
        try {
            view.showUserEvents(model.getEventsByForce(connectedUser.getForce()));
        } catch (Exception e) {
            ErrorBox box = new ErrorBox();
            box.showErrorStage("Not connected to any user");
        }
    }

    public User getConnectedUser(){
        return this.connectedUser ;
    }


}
