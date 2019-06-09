package View;

import Event.*;
import Event.EventDetailsContainer;
import Event.JoinRequestContainer;
import Interfaces.ObserveableObject;
import Objects.StageHolder;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class View extends Observable implements IView , ObserveableObject {

    private Stage primaryStage ;

    public View(){
    }

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage ;
        this.primaryStage.show();
    }

    @Override
    public EventDetailsContainer getEventUpdateFromUser() {

        FXMLLoader loader = new FXMLLoader();
        try{
            Parent root = loader.load(getClass().getClassLoader().getResource("UpdateEventFXML.fxml"));
            Scene scene = new Scene(root);
            //TO DO - add css
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Update event");
            stage.setResizable(false);
            StageHolder.getInstance().holdStage(stage);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    StageHolder.getInstance().getStage() ;
                }
            });

            stage.showAndWait();

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * show a form for the operator to fill the events details
     * @return EventDetailsContainer object which holds the details of the event
     */
    @Override
    public EventDetailsContainer getEventDetailsFromUser(String[] categories) {

        FXMLLoader loader = new FXMLLoader();
        try{
            Parent root = loader.load(getClass().getClassLoader().getResource("CreateEventFXML.fxml"));
            Scene scene = new Scene(root);
            ((ChoiceBox)root.getChildrenUnmodifiable().get(5)).setItems(FXCollections.observableArrayList(categories));
            //TO DO - add css
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Add event");
            stage.setResizable(false);
            StageHolder.getInstance().holdStage(stage);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    StageHolder.getInstance().getStage() ;
                }
            });

            stage.showAndWait();

        }catch (Exception e){
            e.printStackTrace();
        }

        /**
         * show the create new event window . change controller when all loaded successfully
         */
        return null;
    }

    @Override
    public JoinRequestContainer getUserJoinRequest() {

        FXMLLoader loader = new FXMLLoader();
        try{
            Parent root = loader.load(getClass().getClassLoader().getResource("JoinForcesFXML.fxml"));
            Scene scene = new Scene(root);
            //TO DO - add css
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Join Force event");
            stage.setResizable(false);
            StageHolder.getInstance().holdStage(stage);
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    StageHolder.getInstance().getStage() ;
                }
            });

            stage.showAndWait();

        }catch (Exception e){
            e.printStackTrace();
        }

        /**
         * show the join forces window . change controller when all loaded successfully
         */

        return null;
    }

    @Override
    public Event getEventToUpdateFromUser() {


        /**
         * show the update event window . change controller when all loaded successfully
         */

        return null;
    }

    @Override
    public void attachObserver(Observer o) {
        addObserver(o);
    }

    @Override
    public void removeObserver(Observer o) {
        deleteObserver(o);
    }


}
