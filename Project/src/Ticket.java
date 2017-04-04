/**
 * 
 * @author Mark
 * Class for a flight's tickets containing a unique
 * ticket ID number, passenger info, ticket price with
 * 7% sales tax, Flight number, source, and destination,
 * along with flight time and duration.
 */
public class Ticket {
private Integer id = 0;
private Passenger passenger;
private Double ticketPrice = 0.0;
private Double ticketTotalPrice = 0.0;
private Double tax = 1.07;
private Integer flightNumber = 0;
private String flightSource = "";
private String flightDestination = "";
private Date flightDate;
private Time flightTime;
private Time flightDuration;

/**
 * Constructor for class Ticket
 * @param iD value for the unique ticket id of type Integer
 * @param pass value for the passenger for type Passenger
 * @param ticketprice value for the ticket price of type Double
 * @param flightnumber value for the flight number of type Integer
 * @param flightsource value for the flight source of type String
 * @param flightdestination value for the flight destination of type String
 * @param flightdate value for the flight date of type Date
 * @param flighttime value for the flight time of type Time
 * @param flightduration value for the flight duration of type Time
 */
public Ticket(Integer iD, Passenger pass, Double ticketprice, Integer
		flightnumber, String flightsource, String flightdestination,
		Date flightdate, Time flighttime, Time flightduration){
	this.id = iD;
	this.passenger = pass;
	this.ticketPrice = ticketprice;
	this.ticketTotalPrice = this.ticketPrice * this.tax;
	this.flightNumber = flightnumber;
	this.flightSource = flightsource;
	this.flightDestination = flightdestination;
	this.flightDate = flightdate;
	this.flightTime = flighttime;
	this.flightDuration = flightduration;
	
}

/**
 * Default constructor for class Ticket
 */
public Ticket(){}

/**
 * Getter for ticket ID
 * @return value for ticket ID of type Integer
 */
public Integer getTicketID(){
	return this.id;	
}

/**
 * Getter for passenger's first name
 * @return value of passengers first name of type string
 */
public String getfirstName(){
	return this.passenger.getFirstName();
}

/**
 * Getter for passenger's last name
 * @return value of passenger's last name of type String
 */
public String getlastName(){
	return this.passenger.getLastName();
}

/**
 * Getter for passenger's birthday
 * @return value of passenger's birthday of type Date
 */
public Date getBirthday(){
	return this.passenger.getBirthday();
}

/**
 * Getter for ticket's passenger
 * @return value of ticket's pasenger of type Passenger
 */
public Passenger getPassenger(){
	return this.passenger;
}

/**
 * Getter for ticket price
 * @return value of ticket price of type Double
 */
public Double getTicketPrice(){
	return this.ticketPrice;
}

/**
 * Getter for ticket price plus tax
 * @return value for ticket price plus tax of type Double
 */
public Double getTicketTotalPrice(){
	return this.ticketTotalPrice;
}

/**
 * Getter for tax
 * @return value for tax of type Double
 */
public Double getTax(){
	return this.tax;
}

/**
 * Getter for flight number
 * @return value for flight number of type Integer
 */
public Integer getFlightNumber(){
	return this.flightNumber;
}

/**
 * Getter for flight source
 * @return value for flight source of type String
 */
public String getFlightSource(){
	return this.flightSource;
}

/**
 * Getter for flight destination
 * @return value for flight destination of type String
 */
public String getFlightDestination(){
	return this.flightDestination;
}

/**
 * Getter for flight date
 * @return value for flight date of type Date
 */
public Date getFlightDate(){
	return this.flightDate;
}

/**
 * Getter for flight time
 * @return value for flight time of type Time
 */
public Time getFlightTime(){
	return this.flightTime;
}

/**
 * Getter for flight duration
 * @return value for flight duration of type Time
 */
public Time getFlightDuration(){
	return this.flightDuration;
}

/**
 * Setter for flight ID
 * @param iD value for flight id of type Integer
 */
public void setID(Integer iD){
	this.id = iD;
}
/////////////////////////////////////////Potentially add setter for passenger properties//

/**
 * Setter for passenger
 * @param pass value for passenger of type Passenger
 */
public void setPassenger(Passenger pass){
	this.passenger = pass;
}

/**
 * Setter for ticket price and updates total price base on tax
 * @param price value for ticket price of type Double
 */
public void setTicketPrice(Double price){
	this.ticketPrice = price;
	this.ticketTotalPrice = this.ticketPrice * this.tax;
}

/**
 * Setter for tax
 * @param taxx value for tax of type Double
 */
public void setTax(Double taxx){
	this.tax = taxx;
}

/**
 * Setter for flight number
 * @param flightnumber value for flight number of type Integer
 */
public void setFlightNumber(Integer flightnumber){
	this.flightNumber = flightnumber;
}

/**
 * Setter for flight source
 * @param src value for flight source of type String
 */
public void setFlightSource(String src){
	this.flightSource = src;
}

/**
 * Setter for flight destination
 * @param dest value for flight destination of type String
 */
public void setFlightDestination(String dest){
	this.flightDestination = dest;
}

/**
 * Setter for flight time
 * @param flighttim value of flight time of type Time
 */
public void setFlightTime(Time flighttim){
	this.flightTime = flighttim;
}

/**
 * Setter for flight duration
 * @param dur value for flight duration of type Time
 */
public void setFlightDuration(Time dur){
	this.flightDuration = dur;
}
}
