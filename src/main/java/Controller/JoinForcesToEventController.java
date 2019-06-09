package Controller;

import Objects.StageHolder;
import javafx.stage.Stage;

public class JoinForcesToEventController {

    public JoinForcesToEventController(){

    }

    public void cancel_btn(){
        Stage currentStage = StageHolder.getInstance().getCurrentStageClone() ;
        currentStage.close();
    }

    public void submit_btn(){


    }

}
