package Controller;

import Event.*;
import Objects.ErrorBox;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateEventController {


    @FXML
    private TextArea eventUpdate ;
    @FXML
    private TextField eventTitle ;
    @FXML
    private ChoiceBox categoryBox ;


    public void cancel_btn(){

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

        Event newEvent = new Event(new EventUpdate(update,category) , title) ;

        /**
         * save in the db and things
         */

    }

}
