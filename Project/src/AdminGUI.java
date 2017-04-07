import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.*;

/**
 * 
 * @author Brendon
 *
 */
public class AdminGUI extends JFrame implements GUI {

	/**
	 * 
	 */
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
	AdminGUI self;
	
	Container c;
	
	
	public AdminGUI(FlightCatalog flightCatalog)
	{
		self = this;
		this.flightCatalog = flightCatalog;
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
		JPanel pnlTicket = new JPanel(); //ticket manager
		JPanel pnlFlight = new JPanel(); //flight manager
		c = getContentPane();
		//lstDisplay.setSize(400,400);
		lstDisplay.setBackground(Color.WHITE);
		JScrollPane lstDisplayScroll = new JScrollPane(lstDisplay);
		lstDisplayScroll.setPreferredSize(new Dimension(400,480));
		
		pnlBtns.add(btnFlightMgr);
		pnlBtns.add(btnTicketMgr);
		
		pnlTicket.add(btnRefreshT);
		pnlTicket.add(btnSearchT);
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
		this.setPreferredSize(new Dimension(600, 600));
		this.pack();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		printToDisplayF();
		
		btnSearchF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//strArray = new String[2];
        		search = new SearchGUI(self,0);
            	search.setVisible(true);
            	/*
            	actionListener = new ActionListener() { //listens for ok button press
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	strArray = ((SearchGUI) search).getQuery();
                    	System.out.print(strArray);
                    	//TODO Add search functionality here
                    	search.setVisible(false);
                    	search.dispose();
                    }
        		};
        		*/
            }
        });
		
		btnSearchT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//strArray = new String[2];
        		search = new SearchGUI(self,1); //ticket search has more search options
            	search.setVisible(true);
            	/*
            	actionListener = new ActionListener() { //listens for ok button press
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	strArray = ((SearchGUI) search).getQuery();
                    	//TODO Add search functionality here
                    	search.setVisible(false);
                    	search.dispose();
                    }
        		};
        		*/
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
            	//TODO cancel ticket
            }
        });
		
		btnFlightAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame addFlight = new AddFlightGUI(self);
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
            	InputStream is = AdminGUI.class.getResourceAsStream("/resources/"+fileName);
            	System.out.println(is);
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
            	} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
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
            		String selected = lstDisplay.getSelectedValue();
	            	Flight flight = null;
	            	//TODO select Flight object to pass into FlightGUI
	            	JFrame flightData = new FlightGUI(flight);
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
	
	private void printToDisplayF()
	{
		//TODO change to JTable?
		String strTitle = String.format("%10s %15s %15s %10s %10s %10s %3s %7s","Flight Num", "Source", "Destination", "Date", "Time", "Duration", "Seats Avail", "Price");
		DefaultListModel<String> lstModel = new DefaultListModel<String>();
		LinkedList<Flight> flights = flightCatalog.getFlights();
		lstModel.addElement(strTitle);
		for (int i = 0; i < flights.size(); i++)
		{
			lstModel.addElement(flights.get(i).toString());
		}
		
		lstDisplay.setModel(lstModel);
	}
	
	private void printToDisplayT()
	{
		DefaultListModel<String> lstModel = new DefaultListModel<String>();
		LinkedList<Flight> flights = flightCatalog.getFlights();
		for (int i = 0; i < flights.size(); i++)
		{
			LinkedList<Flight> tickets = flightCatalog.getFlights();
			for (int j = 0; j < tickets.size(); j++)
			{
				lstModel.addElement(tickets.get(j).toString());
			}
		}
		
		lstDisplay.setModel(lstModel);
	}
	
	public void searchCriteria(String[] strArray)
	{
		this.strArray = strArray;
	}
	
	public void flightAdd(Flight flight)
	{
		flightCatalog.addFlight(flight);
    	System.out.println(flight.toString());
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
