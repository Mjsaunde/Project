import java.util.LinkedList;

/**
 * 
 * @author Brendon
 *
 */
public class FlightCatalog {
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
				flightCat.addFlight(tempF);
			}
			break;
		case "source": 
			if (tempF.getFlightSource() == Criteria)
			{
				flightCat.addFlight(tempF);
			}
			//TODO implement compare
			break;
		case "destination": 
			if (tempF.getFlightDestination() == Criteria)
			{
				flightCat.addFlight(tempF);
			}
			//TODO implement compare
			break;
		case "flight number": 
			if (tempF.getFlightNumber() == Integer.parseInt(Criteria))
			{
				flightCat.addFlight(tempF);
			}
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
