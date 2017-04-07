import java.io.Serializable;
import java.util.LinkedList;

/**
 * 
 * @author Brendon
 *
 */
public class FlightCatalog implements Serializable{
	private static final long serialVersionUID = 2544143993149409908L;

LinkedList<Flight> flights;

public FlightCatalog()
{
	flights = new LinkedList<Flight>();
}

public FlightCatalog(LinkedList<Flight> flights)
{
	this.flights = flights;
}

public FlightCatalog search(String field, String Criteria)
{
	FlightCatalog flightCat = new FlightCatalog();
	
	for(int i = 0; i < flights.size(); i++)
	{
		Flight tempF = flights.get(i);
		switch(Criteria)
		{
		case "date": 
			if (tempF.getFlightDate().equals(Criteria))
			{
				
			}
			break;
		case "source": 
			//TODO implement compare
			break;
		case "destination": 
			//TODO implement compare
			break;
		case "flight number": 
			//TODO implement compare
			break;
		case "First Name": 
			//TODO implement compare
			break;
		case "Last Name": 
			//TODO implement compare
			break;
		case "Ticket ID": 
			//TODO implement compare
			break;
		}
		
	}
	
	return flightCat;
}

public void addFlight (Flight flight)
{
	//TODO add flight to database
	flights.add(flight);
}

/**
 * @return the flights
 */
public LinkedList<Flight> getFlights() {
	return flights;
}

/**
 * @param flights the flights to set
 */
public void setFlights(LinkedList<Flight> flights) {
	this.flights = flights;
}

}
