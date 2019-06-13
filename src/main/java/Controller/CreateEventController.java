package Controller;

import Event.*;
import Objects.ErrorBox;
import Objects.StageHolder;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateEventController {

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
        category = (String) categoryBox.getSelectionModel().getSelectedItem() ;

        if(title.equals("") || update.equals("") || category.equals("") || category == null) {
            ErrorBox box = new ErrorBox();
            box.showErrorStage("Invalid input");
        }

        Event event = new Event(title ,controller.getTimeStamp() ,"a" ,"a" ,"a" ,update ,category );

        controller.addEventToDB(event);
        cancel_btn();

    }

    public void setController(Controller controller){
        this.controller = controller ;
    }

}
