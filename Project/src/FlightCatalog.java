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

/**
 * default constructor
 */
public FlightCatalog()
{
	flights = new LinkedList<Flight>();
}

/**
 * @param flights
 */
public FlightCatalog(LinkedList<Flight> flights)
{
	this.flights = flights;
}

/**
 * @param field
 * @param Criteria
 * @return
 */
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
				flightCat.addFlight(tempF);
			}
			break;
		case "source": 
			if (tempF.getFlightSource() == Criteria)
			{
				flightCat.addFlight(tempF);
			}
			break;
		case "destination": 
			if (tempF.getFlightDestination() == Criteria)
			{
				flightCat.addFlight(tempF);
			}
			break;
		case "flight number": 
			if (tempF.getFlightNumber() == Integer.parseInt(Criteria))
			{
				flightCat.addFlight(tempF);
			}
			break;
		case "First Name": 
			break;
		case "Last Name": 
			break;
		case "Ticket ID": 
			break;
		}
		
	}
	
	return flightCat;
}

/**
 * @param flight
 */
public void addFlight (Flight flight)
{
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

/**
 * @param obj
 */
public void cancelTicket(Ticket obj)
{
	for (int i = 0; i < flights.size(); i++)
	{
		if(obj.getFlightNumber() == flights.get(i).getFlightNumber())
		{
			flights.get(i).getTicketArray().remove(obj);
			break;
		}
	}
}

}
