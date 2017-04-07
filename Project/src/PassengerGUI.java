import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;

/**
 * 
 * @author Brendon
 *
 */
public class PassengerGUI extends JFrame implements GUI{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JList<String> lstDisplay;
	JButton btnSearch;
	JButton btnFlightData; //to book flight
	JButton btnRefresh;
	String[] strArray; //store search criteria
	ActionListener actionListener;
	FlightCatalog flightCatalog;
	PassengerGUI self;
	JFrame search;
	JFrame flightData;
	LinkedList<Flight> flightsDisplayed;
	
	Container c;
	
	
	public PassengerGUI(FlightCatalog flightCatalog)
	{
		self = this;
		this.flightCatalog = flightCatalog;
		lstDisplay  = new JList<String>();
		btnSearch = new JButton("Search Flights");
		btnFlightData = new JButton("Flight Data");
		JPanel pnlBtns = new JPanel();
		c = getContentPane();
		//lstDisplay.setSize(400,400);
		lstDisplay.setBackground(Color.WHITE);
		JScrollPane lstDisplayScroll = new JScrollPane(lstDisplay);
		lstDisplayScroll.setPreferredSize(new Dimension(400,450));
		
		pnlBtns.add(btnSearch);
		pnlBtns.add(btnFlightData);
		
		
		
		c.add(lstDisplayScroll, BorderLayout.NORTH);
		c.add(pnlBtns, BorderLayout.CENTER);
		c.setBounds(getBounds());
		this.setPreferredSize(new Dimension(600, 600));
		this.pack();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		flightsDisplayed = flightCatalog.getFlights();
		printToDisplay();
		
		
		btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	strArray = new String[2];
            	search = new SearchGUI(self,0);
            	search.setVisible(true);
            	
            	actionListener = new ActionListener() { //listens for ok button press
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	strArray = ((SearchGUI) search).getQuery();
                    	//TODO Add search functionality here
                    	search.setVisible(false);
                    	search.dispose();
                    }
        		};
            }
        });
		
		btnFlightData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (lstDisplay.isSelectionEmpty())
            	{
            		JOptionPane.showMessageDialog(null,"Flight is not selected from list");
            	}
            	else
            	{
	            	int selected = lstDisplay.getSelectedIndex();
	            	Flight flight = null;
	            	//TODO select Flight object to pass into FlightGUI
	            	flight = flightCatalog.getFlights().get(selected);
	            	flightData = new FlightGUI(self, flight);
	            	flightData.setVisible(true);
            	}
            }
        });
		
		btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	printToDisplay();
            }
        });
		
	}
	
	private void printToDisplay()
	{
		//TODO change to JTable?
		String strTitle = String.format("%10s %15s %15s %10s %10s %10s %3s %7s","Flight Num", "Source", "Destination", "Date", "Time", "Duration", "Seats Avail", "Price");
		DefaultListModel<String> lstModel = new DefaultListModel<String>();
		//LinkedList<Flight> flights = flightCatalog.getFlights();
		lstModel.addElement(strTitle);
		for (int i = 0; i < flightsDisplayed.size(); i++)
		{
			lstModel.addElement(flightsDisplayed.get(i).toString());
		}
		
		lstDisplay.setModel(lstModel);
	}
	
	public void searchCriteria(String[] strArray)
	{
		this.strArray = strArray;
		search.setVisible(false);
		search.dispose();
		flightsDisplayed = (flightCatalog.search(strArray[0], strArray[1])).getFlights();
		printToDisplay();
	}
	
	public void bookFlight(Passenger pass,Flight flight)
	{
		//TODO book flight
	}
	//main method for testing purposes:
/*	
	public static void main(String[] args)
	{
		JFrame f = new PassengerGUI();
	    f.setVisible(true);	
	}
*/
	
}
