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

public FlightCatalog search(String field, String Criteria)
{
	FlightCatalog flightCat = new FlightCatalog();
	
	for(int i = 0; i < flights.size(); i++)
	{
		Flight tempF = flights.get(i);
		switch(Criteria)
		{
		case "date": 
			tempF.getFlightDate().equals(Criteria);
			break;
		case "source": 
			
			break;
		case "destination": 
			
			break;
		case "flight number": 
			
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

}
