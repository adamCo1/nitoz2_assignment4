package Controller;

import Event.*;
import Objects.StageHolder;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;


public class UpdateEventController  {

    private Controller controller ;

    @FXML
    private TextField categoryField , eventField ;
    @FXML
    private TextArea updateField ;
    @FXML
    private TableView table ;
    @FXML
    private TableColumn<Event, String> key , value ;

    public UpdateEventController(){
    }

    public void cancel_btn(){
        Stage currentStage = StageHolder.getInstance().getCurrentStageClone();
        currentStage.close();
    }

    public void search_btn() {

        List<Event> eventsToShow = controller.getEvent("title", eventField.getText());
        if (eventsToShow != null) {
            key.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEventTitle()));
            value.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().toString()));
            table.setItems(FXCollections.observableArrayList(eventsToShow));
        }
    }

    public void submit_btn(){

        String category = categoryField.getText() ;
        String update = updateField.getText() ;
        String eventTitle = eventField.getText() ;

        //Event eventToUpdate = controller.getEvent("title",eventTitle);

        /**
         * need authority check here
         */
      // EventUpdate eventUpdate = new EventUpdate(update,"time","adam");
      // eventToUpdate.addUpdateToEvent(eventUpdate);

     //  controller.addEventUpdateToDB(eventUpdate , eventToUpdate) ;

    }

    public void setController(Controller controller){
        this.controller = controller ;
    }
}
