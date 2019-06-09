package Controller;

import Objects.StageHolder;
import javafx.stage.Stage;

public class UpdateEventController  {


    public UpdateEventController(){

    }

    public void cancel_btn(){
        Stage currentStage = StageHolder.getInstance().getCurrentStageClone();
        currentStage.close();
    }

    public void submit_btn(){

    }
}
