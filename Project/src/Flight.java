/**
 * 
 * @author Mark
 * Contains flight information such as flight number,
 * source, destination, and duration, along with available
 * seats, total seats, ticket price, flight time and date.
 */
public class Flight {
private Integer flightNumber = 0;
private String flightSource = "";
private String flightDestination = "";
private Time flightDuration;
private Integer flightSeatsAvailible = 0;
private Integer flightSeatsTotal = 0;
private Double flightPrice = 0.0;
private Ticket[] ticketArray;
private Time flightTime;
private Date flightDate;


}
