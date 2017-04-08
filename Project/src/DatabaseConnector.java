import java.sql.*;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Connects to database and gets/updates values stored there
 * @author Brendon
 *
 */
public class DatabaseConnector {

	String userName = "root";
	String password = "root";
	String serverName = "mysql";
	String dbName = "409ProjectDatabase";
	String dbms = "mysql";
	String portNumber = "3306";
	
	/**
	 * Starts connection to database
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {

	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.userName);
	    connectionProps.put("password", this.password);

	    if (this.dbms.equals("mysql")) {
	        conn = (Connection) DriverManager.getConnection(
	                   "jdbc:" + this.dbms + "://" +
	                   this.serverName +
	                   ":" + this.portNumber + "/",
	                   connectionProps);
	    } else if (this.dbms.equals("derby")) {
	        conn = (Connection) DriverManager.getConnection(
	                   "jdbc:" + this.dbms + ":" +
	                   this.dbName +
	                   ";create=true",
	                   connectionProps);
	    }
	    System.out.println("Connected to database");
	    return conn;
	}
	
	/**
	 * updates values in database
	 * @param flight
	 */
	public void updateDatabase(LinkedList<Flight> flight)
	{
		ResultSet rs = null;
		ResultSet rsT = null;
        Connection connection = null;
        Statement statement = null; 
        
        String query = "SELECT * FROM flights";
        try {           
            connection = getConnection();
            statement = (Statement) connection.createStatement();
            rs = statement.executeQuery(query);
		} catch (SQLException e) {
	        e.printStackTrace();
	    }
		for (int i = 0; i < flight.size(); i++)
		{
			
			for (int j = 0; j < flight.size(); j++)
			{
				//TODO update database
			}
		}
		if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	/**
	 * gets values from database
	 * @return
	 */
	public LinkedList<Flight> getDatabase()
	{
		LinkedList<Flight> flights = new LinkedList<Flight>();
		ResultSet rs = null;
		ResultSet rsT = null;
        Connection connection = null;
        Statement statement = null; 
         
        //Employee employee = null;
        String query = "SELECT * FROM flights";
        try {           
            connection = getConnection();
            statement = (Statement) connection.createStatement();
            rs = statement.executeQuery(query);
            

            if (rs.next()) {
            	query = "SELECT * FROM tickets WHERE "+rs.getInt("idflights");
            	rsT = statement.executeQuery(query); //query ticket
            	LinkedList<Ticket> tickets = new LinkedList<Ticket>(); 
            	if(rsT.next())
            	{
            		Ticket ticket = new Ticket(rsT.getInt("idtickets"),rsT.getString("name"),rsT.getString("Lname"),rsT.getString("Bday"));
            		tickets.add(ticket);
            	}
                Flight flight = new Flight(rs.getInt("idflights"),rs.getString("src"),rs.getString("dest"),
                		rs.getString("duration"),rs.getString("availSeats"),rs.getString("numSeats"),
                		rs.getString("price"),tickets,rs.getString("time"),rs.getString("date"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		
		return flights;
	}
	
}
