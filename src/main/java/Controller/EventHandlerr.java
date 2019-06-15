package Controller;

import Event.*;
import Objects.ErrorBox;
import Objects.StageHolder;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EventHandlerr {

    private Controller controller ;

    @FXML
    private TextArea eventUpdate ;
    @FXML
    private TextField eventTitle ;
    @FXML
    private ChoiceBox categoryBox ;


    public void cancel_btn(){
        Stage currentStage = StageHolder.getInstance().getCurrentStageClone() ;
        currentStage.close();

    }

    public void submit_btn(){

        String title , update , category ;

        title = eventTitle.getText() ;
        update = eventUpdate.getText() ;

        if(title.equals("") || update.equals("")){
            ErrorBox box = new ErrorBox();
            box.showErrorStage("Must fill title field and update field");
            return;
        }

        category = (String) categoryBox.getSelectionModel().getSelectedItem() ;

        if(title.equals("") || update.equals("") ||  category == null || category.equals("") ) {
            ErrorBox box = new ErrorBox();
            box.showErrorStage("Invalid input");
            return;
        }

        Event event = new Event(title ,controller.getTimeStamp() ,controller.getConnectedUser().getUsername() ,"none" ,update ,"none" ,category ,"open");

        controller.addEventToDB(event);
        cancel_btn();

    }

    public void setController(Controller controller){
        this.controller = controller ;
    }

}
