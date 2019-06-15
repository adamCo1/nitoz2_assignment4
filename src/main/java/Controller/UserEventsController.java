package Controller;

import Event.*;
import Objects.ErrorBox;
import Objects.StageHolder;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.List;

public class UserEventsController {


    private Controller controller ;
    private JoinRequest currentRequestSelected ;

    @FXML
    private TableView eventTable , requestsTable ;
    @FXML
    private TableColumn<Event,String> key,value;
    @FXML
    private TableColumn<JoinRequest,String> requestKey , requestValue ;


    public void initializeTable(){

        requestsTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                currentRequestSelected =(JoinRequest) requestsTable.getSelectionModel().getSelectedItem();
            }
        });

        List<ObservableList> eventsAndRequests = controller.getJoinRequests() ;
        if(eventsAndRequests == null)
            return;

        requestKey.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSender()));
        requestValue.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContent()));
        requestsTable.setItems(eventsAndRequests.get(1));

        key.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEventTitle()));
        value.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUpdatesStrings()));
        eventTable.setItems(eventsAndRequests.get(0));
    }

    public void back(){
        Stage currentStage = StageHolder.getInstance().getCurrentStageClone() ;
        currentStage.close();
    }


    public void acceptRequest(){
        if(currentRequestSelected == null){
            ErrorBox box = new ErrorBox();
            box.showErrorStage("You must choose a request first");
            return ;
        }

        controller.acceptJoinRequest(currentRequestSelected);
        initializeTable();
    }

    public void setController(Controller controller){
        this.controller = controller;
    }
}
