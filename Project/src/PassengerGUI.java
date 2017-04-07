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
	String[] strArray; //store search criteria
	ActionListener actionListener;
	FlightCatalog flightCatalog;
	PassengerGUI self;
	
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
		printToDisplay();
		
		
		btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	strArray = new String[2];
            	JFrame search = new SearchGUI(self,0);
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
	            	String selected = lstDisplay.getSelectedValue();
	            	Flight flight = null;
	            	//TODO select Flight object to pass into FlightGUI
	            	JFrame flightData = new FlightGUI(flight);
	            	flightData.setVisible(true);
            	}
            }
        });
		
	}
	
	private void printToDisplay()
	{
		DefaultListModel<String> lstModel = new DefaultListModel<String>();
		LinkedList<Flight> flights = flightCatalog.getFlights();
		for (int i = 0; i < flights.size(); i++)
		{
			lstModel.addElement(flights.get(i).toString());
		}
		
		lstDisplay.setModel(lstModel);
	}
	
	public void searchCriteria(String[] strArray)
	{
		this.strArray = strArray;
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
