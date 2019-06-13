package Model;

import Event.*;
import java.util.List;

public class ModelTest {
    public static void main(String[] args){

        Model model = new Model();

        checkEvents(model);
        // model.initModel();
       // insertCategories(model);
        //tableRecreation(model);

        /****** TESTED OK **************/
        //test create user
            //create user
            //User u = new User("admin","system",10);
            //send to Model function
            // model.createUser("admin","system",10);
            // User u = model.getUser("admin");
            //System.out.println(u.getForce());
            //check exist in db
            //try to use get and check if its ok
        /****   TESTED OK   ****************/
        /*** TESTED OK ******************/
        //test create event
            //create a new event
            //Event e = new Event("crime","timestmp","admin","none","open","none" ,
                    //   "crime");
            //send to create event on model
            //model.createEvent(e);
            //try get event by title
//            Event e = model.getEventByTitle("crime").get(0);
//            System.out.println(e.getUpdateList().size());
//            //System.out.println(e.getOperator());
//            //check fields
//            model.addUpdate(new EventUpdate("first Update","timeStamped","admin"),e);
//            e = model.getEventByTitle("crime").get(0);
//            System.out.println(e.getUpdateList().get(0).getUpdate());
        /*** TESTED OK ******************/

        //test create update
            //get the event
            //check its updates
            //create an update
            //send to model update method
            //retrive event
            //check its updates
        /*** TESTED OK ******************/


        //test send request

        //test login


        //test accept join request




    }


    private static void checkEvents(IModel model){
        List<Event> eventList = model.getEvent("catagory","catA");
        for (Event e:
             eventList) {
            System.out.println(e.toString());
        }
    }

    private static void insertCategories(IModel model){
        String[] categories = {"catA , catB , catC , catD , catE , catE , catF"} ;
        for (String str:
             categories) {
            model.createCatagory(str);
        }
    }

    private static void tableRecreation(Model model){
         model.createUser("admin","system",10);
         Event e = new Event("crime","timestmp","admin","none","open","none" ,
           "crime");
         model.createEvent(e);


    }

}
