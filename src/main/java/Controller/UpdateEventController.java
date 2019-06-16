package Controller;

import Event.*;
import Objects.ErrorBox;
import Objects.StageHolder;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.List;


public class UpdateEventController  {

    private Controller controller ;
    private Event eventToUpdate ;

    @FXML
    private TextField  eventField ;
    @FXML
    private TextArea updateField ;
    @FXML
    private TableView table ;
    @FXML
    private TableColumn<Event, String> key , value ;

    public UpdateEventController(){
    }

    public void initListeners(){
        table.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                eventToUpdate =(Event) table.getSelectionModel().getSelectedItem();
            }
        });
    }

    public void cancel_btn(){
        Stage currentStage = StageHolder.getInstance().getCurrentStageClone();
        currentStage.close();
    }

    public void search_btn() {

        List<Event> eventsToShow = controller.getEvent("title", eventField.getText());
        if (eventsToShow != null) {
            key.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEventTitle()));
            value.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUpdatesStrings()));
            table.setItems(FXCollections.observableArrayList(eventsToShow));
        }
    }

    public void submit_btn(){

        if(eventToUpdate == null){
            ErrorBox box = new ErrorBox();
            box.showErrorStage("Must select an event to update");
            return;
        }

        String update = updateField.getText() ;
        String eventTitle = eventField.getText() ;

        if(update.equals("") || eventTitle.equals("")){
            ErrorBox box = new ErrorBox();
            box.showErrorStage("Must fill update and title fields");
            return;
        }

        //List<Event> eventList = controller.getEvent("title",eventTitle);

        //check for user permissions
        if(!controller.checkWritePermission(eventToUpdate)){
            ErrorBox box = new ErrorBox() ;
            box.showErrorStage("Access for updating this event denied.");
            return;
        }

        //finish the update
        EventUpdate eventUpdate = new EventUpdate(update,controller.getTimeStamp(),"adam");
        eventToUpdate.addUpdateToEvent(eventUpdate);
        controller.addEventUpdateToDB(eventUpdate , eventToUpdate) ;
        cancel_btn();
    }

    public void setController(Controller controller){
        this.controller = controller ;
    }
}
