package Model;

import Controller.Controller;
import Event.*;
import Interfaces.ObserveableObject;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Pair;

import java.sql.*;
import java.util.*;

public class Model  extends Observable implements IModel , ObserveableObject {

    private Controller controller;
    private DriverConnection driver;
    private String loggedUser;
    private ArrayList<Observer>observers;
    private final String SYSTEM = "Emer-Agency system";



    public Model() {

        this.driver = new DriverConnection();
        this.observers = new ArrayList<>();
    }

/**************************************  DATABASE SECTIONS ***********************************************************/


    /****************************************** TABLES CREATION ************************************************/


    public void initModel(){
        this.createUsersTable();
        this.createEventTable();
        this.createNotificationTable();
        this.createCatagoriesTable();
        this.createUpdatesTable();
    }

    /**
     * create a new users table
     */
    public void createUsersTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:emer_agency.db";
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	username text PRIMARY KEY,\n"
                + "	organization text NOT NULL,\n"
                + "	rank double NOT NULL\n"
                + ");";
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    /**
     *
     * Event  table
     * @return
     */

    public void createEventTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:emer_agency.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS events (\n"
                + "	title text PRIMARY KEY,\n"
                + "	creation_time text NOT NULL,\n"
                + "	operator text NOT NULL,\n"
                + "	incharge text,\n"
                + "	handling_force text NOT NULL,\n"
                + " catagory text NOT NULL,\n"
                + "	status text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }



    /**
     * Catagory table
     *
     * @return
     */

    public void createCatagoriesTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:emer_agency.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS catagories (\n"
                + "	name text PRIMARY KEY\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    /**
     *
     * update table
     *
     * @return
     *
     **/

    public void createUpdatesTable() {
    // SQLite connection string
    String url = "jdbc:sqlite:emer_agency.db";

    // SQL statement for creating a new table
    String sql = "CREATE TABLE IF NOT EXISTS updates (\n"
    + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
            + "	event text NOT NULL,\n"
            + " creation_time text NOT NULL,\n"
            + " content text NOT NULL, \n"
            + " publisher text NOT NULL \n"
            + ");";

    try (Connection conn = DriverManager.getConnection(url);
    Statement stmt = conn.createStatement()) {
    // create a new table
    stmt.execute(sql);
    conn.close();
    } catch (SQLException e) {
    e.printStackTrace();
    System.out.println(e.getMessage());
        }
    }




    /**
     *
     *notification Table
     *
     *
     * @return
     */


    public void createNotificationTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:emer_agency.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS notifications (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "	sender text NOT NULL,\n"
                + " reciver text NOT NULL,\n"
                + " event text NOT NULL,\n"
                + " creation_time text NOT NULL,\n"
                + " status text NOT NULL,\n"
                + " content text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }







    /*****************************************  INSERTION TO DB FUNCTIONS *****************************/


    /**
     * create new user
     * @return
     */
    public void createUser(String username,String organization,double rank) {

        String sql = "INSERT INTO users(username, organization, rank) VALUES(?,?,?)";

        try {
            String url = "jdbc:sqlite:emer_agency.db";
            Connection conn = null;

            conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, organization);
            pstmt.setDouble(3, rank);
            pstmt.executeUpdate();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void createCatagory(String catagoryName){

            String sql = "INSERT INTO catagories(name) VALUES(?)";

            try {
                String url = "jdbc:sqlite:emer_agency.db";
                Connection conn = null;

                conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, catagoryName);
                pstmt.executeUpdate();
                conn.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }





    /**
     * create new event
     *
     * @return
     */




    @Override
    public void createEvent(Event event) {
        String sql = "INSERT INTO events(title, creation_time, operator, incharge, handling_force, catagory, status) VALUES(?,?,?,?,?,?,?)";

        try {
            String url = "jdbc:sqlite:emer_agency.db";
            Connection conn = null;

            conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, event.getEventTitle());
            pstmt.setString(2, event.getCreationTime());
            pstmt.setString(3, event.getOperator());
            pstmt.setString(4, event.getIncharge());
            pstmt.setString(5, event.getHandlingForce());
            pstmt.setString(6, event.getCatagory());
            pstmt.setString(7, event.getStatus());
            pstmt.executeUpdate();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }



    /**
     * create new update
     * @return
     */


    @Override
    public void addUpdate(EventUpdate update,Event event) {

        String sql = "INSERT INTO updates(event, creation_time, content, publisher) VALUES(?,?,?,?)";

        try {
            String url = "jdbc:sqlite:emer_agency.db";
            Connection conn = null;

            conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, event.getEventTitle());
            pstmt.setString(2, update.getCreationTime());
            pstmt.setString(3, update.getUpdate());
            pstmt.setString(4, update.getPublisher());



            pstmt.executeUpdate();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    /**
     * create new join request  ----> add to notification table
     * @return
     */

    @Override
    public void sendJoinRequest(JoinRequest joinRequest) {
        String sql = "INSERT INTO notifications(reciver, sender, status, content, creation_time) VALUES(?,?,?,?,?)";

        try {
            String url = "jdbc:sqlite:emer_agency.db";
            Connection conn = null;

            conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, joinRequest.getReciver());
            pstmt.setString(2, joinRequest.getSender());
            pstmt.setString(3, joinRequest.getStatus());
            pstmt.setString(4, joinRequest.getContent());
            pstmt.setString(5, joinRequest.getTimeSent());



            pstmt.executeUpdate();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }








    /******************************************* Find in DATABASE ***************************************************/


    /**
     *
     * get catagories
     *
     *
     * @return
     */
    @Override
    public ObservableList<String> getCatagories() {


            ResultSet resultSet;
            ObservableList<String> catagories = FXCollections.observableArrayList();
            String sqlInboundMessages = "SELECT * FROM catagories";
            try {
                String url = "jdbc:sqlite:emer_agency.db";
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                resultSet = stmt.executeQuery(sqlInboundMessages);
                while(resultSet.next()){
                    catagories.add(resultSet.getString("name"));
                }
                conn.close();



            } catch (SQLException var7) {
                System.out.println("in catch");
                return null;
            }
            return catagories;


    }


    /**
     *
     *
     * get user by username
     *
     * @param
     */


    @Override
    public User getUser(String username) {
        ResultSet resultSet;
        ObservableList<String> users = FXCollections.observableArrayList();
        String sql = "SELECT * FROM users WHERE username = "+ "'" + username + "'";


        User foundUser = null;
        try {
            String url = "jdbc:sqlite:emer_agency.db";
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            resultSet = stmt.executeQuery(sql);
            System.out.println(resultSet.getString("username"));
            while(resultSet.next()){
                foundUser = new User(resultSet.getString("username"),resultSet.getString("organization"),resultSet.getDouble("rank"));
            }
            conn.close();


        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
            return null;
        }
        return foundUser;


    }


    @Override
    public ObservableList<JoinRequest> getNotifications(String username) {




        ResultSet resultSet;
        ObservableList<JoinRequest> notifications = FXCollections.observableArrayList();
        String sql = "SELECT * FROM notifications WHERE reciver = "+ "'" + username + "'";
        JoinRequest jr = null;
        try {
            String url = "jdbc:sqlite:emer_agency.db";
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            resultSet = stmt.executeQuery(sql);
            while(resultSet.next()){

                jr = new JoinRequest(resultSet.getString("sender"),resultSet.getString("reciver"),resultSet.getString("event"),resultSet.getString("creation_time"),resultSet.getString("status"),resultSet.getString("content"));
                notifications.add(jr);
            }
            conn.close();



        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
            return null;
        }
        return notifications;



    }

    @Override
    public User getContactSecurityUser(String securityForce) {


        ResultSet resultSet;
        ObservableList<String> users = FXCollections.observableArrayList();
        String sqlInboundMessages = "SELECT * FROM users WHERE organization = "+ "'" + securityForce + "'";
        User foundUser = null;
        try {
            String url = "jdbc:sqlite:emer_agency.db";
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            resultSet = stmt.executeQuery(sqlInboundMessages);
            conn.close();
            while(resultSet.next()){
               foundUser = new User(resultSet.getString("username"),resultSet.getString("organization"),resultSet.getDouble("rank"));

            }


        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
            return null;
        }
        return foundUser;


    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;

    }


    /**
     *
     * find event by name or catagory
     * @param
     * @param
     */


    public ObservableList<Event> getEvent(String field,String value) {
      //first get the updates

      //hold them and close connection

      //now find the event, create it and append to its updates
        ResultSet resultSet;
        ObservableList<Event> events = FXCollections.observableArrayList();
        //HashMap<String,EventUpdate> updatesMap = new HashMap<String, EventUpdate>();
        ArrayList<EventUpdate> updates = new ArrayList<EventUpdate>();
        //String sqlEvents = "SELECT * FROM events WHERE "+"'" + field+ "'"+" = " + "'" + value+ "'";
        String sqlEvents = "SELECT * FROM events WHERE "+field+" = " + "'" + value+ "'";
        User foundUser = null;
        try {
            String url = "jdbc:sqlite:emer_agency.db";
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            resultSet = stmt.executeQuery(sqlEvents);
            while(resultSet.next()){
                events.add(new Event(resultSet.getString("title"),resultSet.getString("creation_time"),
                        resultSet.getString("operator"),resultSet.getString("incharge"),
                        resultSet.getString("status"),resultSet.getString("handling_force"),resultSet.getString("catagory")));
            }
            conn.close();

            //now get all related updates
            String sqlupdates = "SELECT * FROM updates";
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(sqlupdates);
            String currEvent="";
            EventUpdate currUpdate = null;
            while(resultSet.next()){
                currEvent = resultSet.getString("event");
                currUpdate = new EventUpdate(resultSet.getString("content"),resultSet.getString("creation_time"),resultSet.getString("publisher"));
                for(Event e: events){
                    if(e.getEventTitle().equals(currEvent)) {
                        e.addUpdateToEvent(currUpdate);
                        break;
                    }
                }
            }
            conn.close();
        } catch (SQLException var7) {
            System.out.println(var7.getMessage());
            return null;
        }
        return events;

    }

    @Override
    public ObservableList<Event> getEventsByCatagory(String name) {
        return this.getEvent("catagory",name);
    }

    @Override
    public ObservableList<Event> getEventByTitle(String name) {
        return this.getEvent("title",name);
    }

    @Override
    public ObservableList<Event> getEventsByForce(String name) {
        return this.getEvent("handling_force",name);
    }


    /***************************************** EDIT DATABASE *******************************************************/


    /**
     * edit the notification table
     * @param joinRequest
     */

    @Override
    public void acceptJoinRequest(JoinRequest joinRequest) {
        String url = "jdbc:sqlite:emer_agency.db";
        User reciver = getUser(joinRequest.getReciver());
        //update the event
        String sqlStatement = "UPDATE events SET handling_force = " +"'"+reciver.getForce()+"'"+", incharge = " +"'"+reciver.getUsername()+"'"+" WHERE title = " + "'" + joinRequest.getEvent() + "'";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sqlStatement);
            pstmt.executeUpdate();
            conn.close();
            notifyObservers(login(joinRequest.getReciver()));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     *
     * @param username
     * @return a list of lists! in this order: user data, events, notifications
     */
    @Override
    public List<ObservableList> login(String username) {
        User u = getUser(username);
        ObservableList<User> user = FXCollections.observableArrayList();
        user.add(u);
        List<ObservableList> ans = new ArrayList<>();
        ans.add(user);
        ans.add(this.getEventsByForce(u.getForce()));
        ans.add(this.getNotifications(username));

        return ans;
    }

    @Override
    public boolean checkWritePremission(User u, Event e){
        User incharge = this.getUser(e.getIncharge());
        if( u.getForce().equals(incharge.getForce()) && u.getRank()>= incharge.getRank())
            return true;
        return false;

    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    @Override
    public void notifyObservers(Object arg) {

        super.notifyObservers(arg);
    }

    @Override
    public void attachObserver(Observer o) {
        addObserver(o);
    }

    @Override
    public void removeObserver(Observer o) {
        deleteObserver(o);
    }
}
