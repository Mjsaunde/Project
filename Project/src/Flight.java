import java.util.LinkedList;

/**
 * 
 * @author Mark
 * @author Brendon
 * Contains flight information such as flight number,
 * source, destination, and duration, along with available
 * seats, total seats, ticket price, flight time and date.
 */
/**
 * @author Brendon
 *
 */
public class Flight {
private Integer flightNumber = 0;
private String flightSource = "";
private String flightDestination = "";
private Time flightDuration;
private Integer flightSeatsAvailible = 0;
private Integer flightSeatsTotal = 0;
private Double flightPrice = 0.0;
private LinkedList<Ticket> ticketArray;
private Time flightTime;
private Date flightDate;

/**
 * @param flightNumber
 * @param flightSource
 * @param flightDestination
 * @param flightDuration
 * @param flightSeatsAvailible
 * @param flightSeatsTotal
 * @param flightPrice
 * @param ticketArray
 * @param flightTime
 * @param flightDate
 */
public Flight(Integer flightNumber, String flightSource, String flightDestination, Time flightDuration,
		Integer flightSeatsAvailible, Integer flightSeatsTotal, Double flightPrice, LinkedList<Ticket> ticketArray,
		Time flightTime, Date flightDate) {
	super();
	this.flightNumber = flightNumber;
	this.flightSource = flightSource;
	this.flightDestination = flightDestination;
	this.flightDuration = flightDuration;
	this.flightSeatsAvailible = flightSeatsAvailible;
	this.flightSeatsTotal = flightSeatsTotal;
	this.flightPrice = flightPrice;
	this.ticketArray = ticketArray;
	this.flightTime = flightTime;
	this.flightDate = flightDate;
}


/**
 * @param flightNumber
 * @param flightSource
 * @param flightDestination
 * @param flightDuration
 * @param flightSeatsTotal
 * @param flightPrice
 * @param flightTime
 * @param flightDate
 */
public Flight(Integer flightNumber, String flightSource, String flightDestination, String flightDuration,
		String flightSeatsTotal, String flightPrice,
		String flightTime, String flightDate) {
	this.flightNumber = flightNumber;
	this.flightSource = flightSource;
	this.flightDestination = flightDestination;
	this.flightDuration = new Time(flightDuration);
	this.flightSeatsAvailible = Integer.parseInt(flightSeatsTotal);
	this.flightSeatsTotal = Integer.parseInt(flightSeatsTotal);
	this.flightPrice = Double.parseDouble(flightPrice);
	ticketArray = new LinkedList<Ticket>();
	this.flightTime = new Time(flightTime);
	this.flightDate = new Date(flightDate);
}

/**
 * @param flightNumber
 * @param flightSource
 * @param flightDestination
 * @param flightDuration
 * @param flightSeatsAvailible
 * @param flightSeatsTotal
 * @param flightPrice
 * @param ticketArray
 * @param flightTime
 * @param flightDate
 */
public Flight(Integer flightNumber, String flightSource, String flightDestination, String flightDuration,
		String flightSeatsAvailible, String flightSeatsTotal, String flightPrice, LinkedList<Ticket> ticketArray,
		String flightTime, String flightDate) {
	this.flightNumber = flightNumber;
	this.flightSource = flightSource;
	this.flightDestination = flightDestination;
	this.flightDuration = new Time(flightDuration);
	this.flightSeatsAvailible = Integer.parseInt(flightSeatsAvailible);
	this.flightSeatsTotal = Integer.parseInt(flightSeatsTotal);
	this.flightPrice = Double.parseDouble(flightPrice);
	ticketArray = new LinkedList<Ticket>();
	this.flightTime = new Time(flightTime);
	this.flightDate = new Date(flightDate);
}

/**
 * @param flightNum
 * @return
 */
public Integer updateSeats(Integer flightNum)
{
	flightSeatsAvailible = flightSeatsTotal - ticketArray.size();
	return flightSeatsAvailible;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
public String toString()
{
	String str = String.format("%10s %17s %17s %20s %10s %10s %10s %15.2f",flightNumber, flightSource, flightDestination, flightDate, flightTime, flightDuration, flightSeatsAvailible, flightPrice);
	return str;
}

/**
 * @return the flightNumber
 */
public Integer getFlightNumber() {
	return flightNumber;
}
/**
 * @return the flightSource
 */
public String getFlightSource() {
	return flightSource;
}
/**
 * @return the flightDestination
 */
public String getFlightDestination() {
	return flightDestination;
}
/**
 * @return the flightDuration
 */
public Time getFlightDuration() {
	return flightDuration;
}
/**
 * @return the flightSeatsAvailible
 */
public Integer getFlightSeatsAvailible() {
	return flightSeatsAvailible;
}
/**
 * @return the flightSeatsTotal
 */
public Integer getFlightSeatsTotal() {
	return flightSeatsTotal;
}
/**
 * @return the flightPrice
 */
public Double getFlightPrice() {
	return flightPrice;
}
/**
 * @return the ticketArray
 */
public LinkedList<Ticket> getTicketArray() {
	return ticketArray;
}
/**
 * @return the flightTime
 */
public Time getFlightTime() {
	return flightTime;
}
/**
 * @return the flightDate
 */
public Date getFlightDate() {
	return flightDate;
}
/**
 * @param flightNumber the flightNumber to set
 */
public void setFlightNumber(Integer flightNumber) {
	this.flightNumber = flightNumber;
}
/**
 * @param flightSource the flightSource to set
 */
public void setFlightSource(String flightSource) {
	this.flightSource = flightSource;
}
/**
 * @param flightDestination the flightDestination to set
 */
public void setFlightDestination(String flightDestination) {
	this.flightDestination = flightDestination;
}
/**
 * @param flightDuration the flightDuration to set
 */
public void setFlightDuration(Time flightDuration) {
	this.flightDuration = flightDuration;
}
/**
 * @param flightSeatsAvailible the flightSeatsAvailible to set
 */
public void setFlightSeatsAvailible(Integer flightSeatsAvailible) {
	this.flightSeatsAvailible = flightSeatsAvailible;
}
/**
 * @param flightSeatsTotal the flightSeatsTotal to set
 */
public void setFlightSeatsTotal(Integer flightSeatsTotal) {
	this.flightSeatsTotal = flightSeatsTotal;
}
/**
 * @param flightPrice the flightPrice to set
 */
public void setFlightPrice(Double flightPrice) {
	this.flightPrice = flightPrice;
}
/**
 * @param ticketArray the ticketArray to set
 */
public void setTicketArray(LinkedList<Ticket> ticketArray) {
	this.ticketArray = ticketArray;
}
/**
 * @param flightTime the flightTime to set
 */
public void setFlightTime(Time flightTime) {
	this.flightTime = flightTime;
}
/**
 * @param flightDate the flightDate to set
 */
public void setFlightDate(Date flightDate) {
	this.flightDate = flightDate;
}



}