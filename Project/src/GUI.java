
public interface GUI {

	/**
	 * This method assigns searchCriteria
	 * @param strArray
	 */
	public void searchCriteria(String[] strArray);
	
	/**
	 * Books flights
	 * @param pass
	 * @param flight
	 */
	public void bookFlight(Passenger pass,Flight flight);
	
}
