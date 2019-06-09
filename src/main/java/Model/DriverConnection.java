package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverConnection {

    private static Connection conn;


    /**
     * close the connection
     */
    public void closeConnection(){
        try{
            this.conn.close();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     * Connect to a Control database
     */
    public Connection connect() {

        try {
            // db parameters
            String url = "jdbc:sqlite:emer_agency.db";
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }







}