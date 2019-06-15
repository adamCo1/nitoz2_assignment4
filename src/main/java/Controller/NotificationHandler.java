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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NotificationHandler {

    @FXML
    private TextField eventsField , userField;
    @FXML
    private TableView eventsTable , usersTable ;
    @FXML
    private TableColumn<Event,String> details_event , event  ;
    @FXML
    private TableColumn<User,String> details_user , user ;

    private User currentUserSelected ;
    private Controller controller ;

    public NotificationHandler(){

    }

    public void initListeners(){

        usersTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                currentUserSelected =(User) usersTable.getSelectionModel().getSelectedItem();
            }
        });

    }

    public void cancel_btn(){
        Stage currentStage = StageHolder.getInstance().getCurrentStageClone() ;
        currentStage.close();
    }

    public void searchUsers(){
        String usersType = userField.getText();

        user.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsername()));
        details_user.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getForce()));

        ObservableList<User> users = controller.getUsersByForce(usersType);
        usersTable.setItems(users);
    }

    public void searchEvents(){
        String eventTitle = eventsField.getText();

        event.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEventTitle()));
        details_event.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUpdatesStrings()));

        ObservableList<Event> eventList = controller.getEvent("title",eventTitle);
        eventsTable.setItems(eventList);
    }

    public void submit_btn(){

        String sender , receiver , title;

        title = eventsField.getText() ;
        if(title.equals("")){
            ErrorBox box = new ErrorBox();
            box.showErrorStage("Must fill event title first");
            return;
        }

        if(currentUserSelected == null){
            ErrorBox box = new ErrorBox();
            box.showErrorStage("Must select a user");
            return;
        }

        receiver = currentUserSelected.getUsername();
        sender = controller.getConnectedUser().getUsername();
        controller.sendJoinRequest(new JoinRequest(sender,receiver,title, controller.getTimeStamp(),"open","COME QUICK"));

        cancel_btn();
    }

    public void setController(Controller controller){
        this.controller = controller ;
    }
}
