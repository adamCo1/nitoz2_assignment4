package Controller;

import Interfaces.ObserveableObject;
import Model.IModel;
import Model.Model;
import Objects.StageHolder;
import View.IView;
import View.View;
import javafx.stage.Stage;

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
        String[] allCategories = model.getAllPossibleCategories() ;
        String[] test = {"A","B","C","D","E"};
        view.getEventDetailsFromUser(test) ;
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

    @Override
    public void update(Observable o, Object arg) {

    }
}
