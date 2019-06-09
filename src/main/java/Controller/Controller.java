package Controller;

import Event.Event;
import Event.EventDetailsContainer;
import Interfaces.ObserveableObject;
import Model.IModel;
import Model.Model;
import View.IView;
import View.View;
import java.time.LocalDateTime;
import Event.* ;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    private IModel model ;
    private IView view ;


    public Controller(){
        this.model = new Model() ;
        this.view = new View() ;
        ((ObserveableObject)view).attachObserver(this);
        ((ObserveableObject)model).attachObserver(this);

    }

    /**
     *
     */
    public void createNewEvent(){



        LocalDateTime now;

        List<String> categoryList = model.getAllPossibleCategories() ;
        EventDetailsContainer eventDetailsContainer = view.getEventDetailsFromUser(categoryList) ;//get all event details from user
        now = LocalDateTime.now();//time stamp .. need to finish this
        Event event = new Event(eventDetailsContainer.getUpdate() , eventDetailsContainer.getTitle()) ;

        model.addEventToSystem(event) ;

    }

    public void updateEvent(){

        Event eventToUpdate = view.getEventToUpdateFromUser();//need to decide how we let the user pick
        //the event he wants to update . from a Db , from a Collection ?

        if(!eventToUpdate.getOpen()){//if event is closed , end process
            System.out.println("error . closing operation");
            return;
        }

        //need to add here a check if the user has the authority to update the event , else return with error
        //fill this when we decide how to do it

        EventDetailsContainer eventDetails = view.getEventUpdateFromUser() ;
        //update the event
        eventToUpdate.addUpdateToEvent(new EventUpdate(eventDetails.getUpdate()));


    }

    /**
     * join force UC
     */
    public void joinForceToEvent(){

        JoinRequestContainer joinRequest = view.getUserJoinRequest();
        model.pushJoinRequestToEvent(joinRequest) ;
        //after storage send the notification to the right user


        //we need to decide how to handle the notifications thing
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
