package Controller;

import Event.Event;
import Objects.StageHolder;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class UserEventsController {


    @FXML
    private TableView eventTable ;
    @FXML
    private TableColumn<Event,String> key,value ;


    public void initializeTable(ObservableList<Event> eventList){
        key.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEventTitle()));
        value.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().toString()));

        eventTable.setItems(eventList);
    }

    public void back(){
        Stage currentStage = StageHolder.getInstance().getCurrentStageClone() ;
        currentStage.close();
    }

}
