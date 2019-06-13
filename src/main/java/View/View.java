package View;

import Controller.Controller;
import Event.*;
import Interfaces.ObserveableObject;
import Objects.StageHolder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import Controller.*;

public class View extends Observable implements IView , Observer {

    private Stage primaryStage ;
    private Controller controller ;

    public View(){
    }

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage ;
        this.primaryStage.show();
    }

    @Override
    public void getEventUpdateFromUser() {

        FXMLLoader loader = new FXMLLoader();
        try{
            Parent root = loader.load(getClass().getClassLoader().getResource("UpdateEventFXML.fxml").openStream());
            Scene scene = new Scene(root);
            //TO DO - add css
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Update event");
            stage.setResizable(false);
            UpdateEventController ctrl = loader.getController() ;
            ctrl.setController(controller);
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

    }

    /**
     * show a form for the operator to fill the events details
     * @return EventDetailsContainer object which holds the details of the event
     */
    @Override
    public void getEventDetailsFromUser(ObservableList<String> categories) {

        FXMLLoader loader = new FXMLLoader();
        try{
            Parent root = loader.load(getClass().getClassLoader().getResource("CreateEventFXML.fxml").openStream());
            Scene scene = new Scene(root);
            ((ChoiceBox)root.getChildrenUnmodifiable().get(5)).setItems(categories);
            //TO DO - add css
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Add event");
            stage.setResizable(false);
            CreateEventController ctrl = loader.getController() ;
            ctrl.setController(controller);
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

    }

    /**
     * show the user the join forces window
     */
    @Override
    public void getUserJoinRequest() {

        FXMLLoader loader = new FXMLLoader();
        try{
            Parent root = loader.load(getClass().getClassLoader().getResource("JoinForcesFXML.fxml").openStream());
            Scene scene = new Scene(root);
            //TO DO - add css
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Join Force event");
            stage.setResizable(false);
            JoinForcesToEventController ctrl = loader.getController() ;
            ctrl.setController(controller);
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
    }

    @Override
    public Event getEventToUpdateFromUser() {


        /**
         * show the update event window . change controller when all loaded successfully
         */

        return null;
    }

    public void setController(Controller controller){
        this.controller = controller ;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
