package Controller;

import Objects.ErrorBox;
import Objects.StageHolder;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Event.* ;
import java.awt.*;

public class UpdateEventController  {

    private Controller controller ;

    @FXML
    private TextField categoryField , eventField ;
    @FXML
    private TextArea updateField ;

    public UpdateEventController(){

    }

    public void cancel_btn(){
        Stage currentStage = StageHolder.getInstance().getCurrentStageClone();
        currentStage.close();
    }

    public void submit_btn(){

        String category = categoryField.getText() ;
        String update = updateField.getText() ;
        String eventTitle = eventField.getText() ;

        Event.Event eventToUpdate = controller.getEventFromDB(eventTitle);
        if(!eventToUpdate.getOpen()){
            ErrorBox box = new ErrorBox();
            box.showErrorStage("Event is closed");
            return ;
        }

        /**
         * need authority check here
         */

        EventUpdate eventUpdate = new EventUpdate(update,category);
        eventToUpdate.addUpdateToEvent(eventUpdate);

        controller.addEventUpdateToDB(eventUpdate , eventToUpdate) ;

    }

    public void setController(Controller controller){
        this.controller = controller ;
    }
}
