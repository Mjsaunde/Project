import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.*;

/**
 * GUI for admin
 * @author Brendon
 *
 */
public class AdminGUI extends JFrame implements GUI {


	private static final long serialVersionUID = 1L;
	JList<String> lstDisplay;
	
	JButton btnSearchF;
	JButton btnSearchT;
	JButton btnFlightMgr;
	JButton btnTicketMgr;
	JButton btnRefreshF;
	JButton btnRefreshT;
	
	JButton btnTicketCancel;
	JButton btnTicketBook;
	JButton btnFlightAdd;
	JButton btnFlightLoad;
	String[] strArray; //store search criteria
	ActionListener actionListener;
	FlightCatalog flightCatalog;
	JFrame search;
	JFrame addFlight;
	JFrame flightData;
	JPanel pnlTicket;
	JPanel pnlFlight;
	AdminGUI self;
	LinkedList<Flight> flightsDisplayed;
	//ClientAdmin client;
	
	Container c;
	
	//ClientAdmin client,
	/**
	 * Constructor
	 * @param flightCatalog
	 */
	public AdminGUI( FlightCatalog flightCatalog)
	{
		self = this;
		//this.client = client;
		this.flightCatalog = flightCatalog;
		flightsDisplayed = flightCatalog.getFlights();
		lstDisplay  = new JList<String>();
		btnSearchF = new JButton("Search");
		btnSearchT = new JButton("Search");
		btnFlightMgr = new JButton("Flight Manager");
		btnTicketMgr = new JButton("Ticket Manager");
		btnTicketCancel = new JButton("Cancel Selected Ticket");
		btnTicketBook = new JButton("Book Ticket");
		btnFlightAdd = new JButton("Add Flight");
		btnFlightLoad = new JButton("Load flights from file");
		btnRefreshF = new JButton("Refresh Flights");
		btnRefreshT = new JButton("Refresh Tickets");
		JPanel pnlBtns = new JPanel();
		pnlTicket = new JPanel(); //ticket manager
		pnlFlight = new JPanel(); //flight manager
		c = getContentPane();
		//lstDisplay.setSize(400,400);
		lstDisplay.setBackground(Color.WHITE);
		JScrollPane lstDisplayScroll = new JScrollPane(lstDisplay);
		lstDisplayScroll.setPreferredSize(new Dimension(500,480));
		
		pnlBtns.add(btnFlightMgr);
		pnlBtns.add(btnTicketMgr);
		
		pnlTicket.add(btnRefreshT);
		//pnlTicket.add(btnSearchT);
		pnlTicket.add(btnTicketCancel);
		
		pnlFlight.add(btnRefreshF);
		pnlFlight.add(btnSearchF);
		pnlFlight.add(btnFlightAdd);
		pnlFlight.add(btnFlightLoad);
		pnlFlight.add(btnTicketBook);
		
		JPanel pnlBottom = new JPanel();
		pnlBottom.add(pnlTicket);
		pnlBottom.add(pnlFlight);
		pnlTicket.setVisible(false); 
    	pnlFlight.setVisible(true); // default display flight manager
		
		c.add(lstDisplayScroll, BorderLayout.NORTH);
		c.add(pnlBtns, BorderLayout.CENTER);
		//c.add(pnlTicket, BorderLayout.SOUTH);
		c.add(pnlBottom, BorderLayout.SOUTH);
		c.setBounds(getBounds());
		this.setPreferredSize(new Dimension(700, 600));
		this.pack();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		flightsDisplayed = flightCatalog.getFlights();
		printToDisplayF();
		
		btnSearchF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//strArray = new String[2];
        		search = new SearchGUI(self,0);
            	search.setVisible(true);
            }
        });
		
		btnSearchT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//strArray = new String[2];
        		search = new SearchGUI(self,1); //ticket search has more search options
            	search.setVisible(true);
            }
        });
		
		
		
		btnFlightMgr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	pnlTicket.setVisible(false);
            	pnlFlight.setVisible(true);
            }
        });
		
		btnTicketMgr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	pnlFlight.setVisible(false);
            	pnlTicket.setVisible(true);
            }
        });
		
		
		btnTicketCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Ticket obj = null;
            	int selected = lstDisplay.getSelectedIndex();
            	int counter = 0;
            	for (int i = 0; i < flightsDisplayed.size(); i++, counter++)
        		{
        			LinkedList<Ticket> tickets = flightsDisplayed.get(i).getTicketArray();
        			for (int j = 0; j < tickets.size(); j++, counter++)
        			{
        				if (counter == selected)
        				{
        				obj = tickets.get(j);
        				break;
        				}
        			}
        		}
            	flightCatalog.cancelTicket(obj);
            }
        });
		
		btnFlightAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	addFlight = new AddFlightGUI(self);
            	addFlight.setVisible(true);
            }
        });
		
		btnFlightLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//TODO Check for flight duplicates
            	String fileName = JOptionPane.showInputDialog("Enter the file name:");
            	File myFile = new File(fileName);
            	try {
					System.out.println("Attempting to read from file: "+myFile.getCanonicalPath());
				} catch (IOException e2) {
					e2.printStackTrace();
				}
            	while(true)
            	{
            	try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            	    StringBuilder sb = new StringBuilder();
            	    String line = br.readLine();
            	    if (!line.startsWith("#"))
            	    {
            	    	List<String> items = Arrays.asList(line.split("\\s*,\\s*"));
                	    Flight flight = new Flight(Integer.parseInt(items.get(0)),items.get(1),items.get(2),items.get(5),
                	    		items.get(6),items.get(7),items.get(4),items.get(3));
            	        flightCatalog.addFlight(flight);
            	    }

            	    while (line != null) {
            	        sb.append(line);
            	        sb.append(System.lineSeparator());
            	        line = br.readLine();
            	        if (line != null && !line.startsWith("#"))
            	        {
	            	        List<String> items = Arrays.asList(line.split("\\s*,\\s*"));
	                	    Flight flight = new Flight(Integer.parseInt(items.get(0)),items.get(1),items.get(2),items.get(5),
	                	    		items.get(6),items.get(7),items.get(4),items.get(3));
	            	        flightCatalog.addFlight(flight);
            	        }
            	    }
            	    break;
            	} catch (FileNotFoundException e1) {
            		fileName = JOptionPane.showInputDialog("File name invalid, please re-enter the file name:");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            	}
            }
        });
		
		btnTicketBook.addActionListener(new ActionListener() {
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
	            	System.out.println(selected);
	            	flight = flightCatalog.getFlights().get(selected);
	            	flightData = new FlightGUI(self, flight);
	            	flightData.setVisible(true);
            	}
            }
        });
		
		btnRefreshF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	printToDisplayF();
            }
        });
		
		btnRefreshT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	printToDisplayT();
            }
        });
		
	}
	
	/**
	 * Prints flights to JList
	 */
	private void printToDisplayF()
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
	
	/**
	 * Prints tickets to JList
	 */
	private void printToDisplayT()
	{
		DefaultListModel<String> lstModel = new DefaultListModel<String>();
		//LinkedList<Flight> flights = flightCatalog.getFlights();
		for (int i = 0; i < flightsDisplayed.size(); i++)
		{
			LinkedList<Ticket> tickets = flightsDisplayed.get(i).getTicketArray();
			for (int j = 0; j < tickets.size(); j++)
			{
				lstModel.addElement(tickets.get(j).toString());
			}
		}
		
		lstDisplay.setModel(lstModel);
	}
	
	/* (non-Javadoc)
	 * @see GUI#searchCriteria(java.lang.String[])
	 */
	public void searchCriteria(String[] strArray)
	{
		this.strArray = strArray;
		search.setVisible(false);
		search.dispose();
		if (pnlFlight.isVisible())
		{
			flightsDisplayed = (flightCatalog.search(strArray[0], strArray[1])).getFlights();
			printToDisplayF();
		}
		else
		{
			//TODO ticket search here
		}
	}
	
	/**
	 * adds flight to catalog and sends to sever
	 * @param flight
	 */
	public void flightAdd(Flight flight)
	{
		flightCatalog.addFlight(flight);
		//client.addFlight(flight);
    	System.out.println(flight.toString());
    	addFlight.setVisible(false);
    	addFlight.dispose();
	}
	
	/* (non-Javadoc)
	 * @see GUI#bookFlight(Passenger, Flight)
	 */
	public void bookFlight(Passenger pass,Flight flight)
	{
		boolean accepted = client.bookFlight(pass,flight);
		//TODO book flight
	}
	
	//main method for testing purposes:
	/*
	public static void main(String[] args)
	{
		JFrame f = new AdminGUI();
	    f.setVisible(true);	
	}
	*/
}
