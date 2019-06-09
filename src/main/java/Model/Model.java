package Model;

import Controller.Controller;
import Event.*;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;
import java.util.Observable;

public class Model implements IModel {

    private Controller controller;
    private DriverConnection driver;
    private String loggedUser = "";
    private final String SYSTEM = "Emer-Agency system";


    public Model() {
        this.driver = new DriverConnection();
    }

/**************************************  DATABASE SECTIONS ***********************************************************/


    /****************************************** TABLES CREATION ************************************************/


    /**
     * create a new users table
     */
    public void createUsersTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:emer_agency.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	username text PRIMARY KEY,\n"
                + "	organization text NOT NULL\n"
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
                + "	status text NOT NULL,\n"
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
            + " creation_time text NOT NULL\n"
            + " content text NOT NULL "
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
                + " status text NOT NULL,\n"
                + " content text NOT NULL,\n"
                + " creation_time text NOT NULL,\n"
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
    public void createUser(String username,String organization) {

        String sql = "INSERT INTO users(username, organization) VALUES(?,?)";

        try {
            String url = "jdbc:sqlite:emer_agency.db";
            Connection conn = null;

            conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, organization);
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
        String sql = "INSERT INTO events(title, creation_time, operator, incharge, handling_force, status) VALUES(?,?,?,?,?,?)";

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
            pstmt.setString(6, event.getStatus());
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

        String sql = "INSERT INTO updates(event, creation_time, content) VALUES(?,?,?)";

        try {
            String url = "jdbc:sqlite:emer_agency.db";
            Connection conn = null;

            conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, event.getEventTitle());
            pstmt.setString(2, update.getCreationTime());
            pstmt.setString(3, update.getUpdate());

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


            //get user inMessages
            ResultSet resultSet;
            ObservableList<String> catagories = null;
            String sqlInboundMessages = "SELECT * FROM catagories";
            try {
                String url = "jdbc:sqlite:emer_agency.db";
                Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                resultSet = stmt.executeQuery(sqlInboundMessages);
                conn.close();
                while(resultSet.next()){
                    catagories.add(resultSet.getString("name"));
                }


//            outboundMessages = this.convertOutMessageResultsToObservableList(resultSetOut);
            } catch (SQLException var7) {
                System.out.println(var7.getMessage());
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
    public void getUser(String username) {


    }



    @Override
    public void getContactSecurityUser(String securityForce) {

    }

    @Override
    public void setController(Controller controller) {

    }


    /**
     *
     * find event by name or catagory
     * @param
     * @param
     */

    @Override
    public void getEvent(String catagory) {

    }


    /***************************************** EDIT DATABASE *******************************************************/


    /**
     * edit the notification table
     * @param joinRequest
     * @param accepterUsername
     */

    @Override
    public void acceptJoinRequest(JoinRequest joinRequest, String accepterUsername) {

    }













}
