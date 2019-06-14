package Controller;

import Objects.StageHolder;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LogInController {

    @FXML
    private TextField username ;

    private Controller controller;

    public void back(){
        Stage currentStage = StageHolder.getInstance().getCurrentStageClone() ;
        currentStage.close();
    }

    public void login(){
        controller.loginFromDB(username.getText());
        back();
    }

    public void setController(Controller controller){
        this.controller = controller;
    }
}
