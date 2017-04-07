import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 * @author Brendon
 *
 */
public class AdminGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JList<String> lstDisplay;
	
	JButton btnSearchF;
	JButton btnSearchT;
	JButton btnFlightMgr;
	JButton btnTicketMgr;
	
	
	JButton btnTicketCancel;
	JButton btnTicketBook;
	JButton btnFlightAdd;
	JButton btnFlightLoad;
	String[] strArray; //store search criteria
	ActionListener actionListener;
	JFrame search;
	
	Container c;
	
	
	public AdminGUI()
	{
		lstDisplay  = new JList<String>();
		btnSearchF = new JButton("Search");
		btnSearchT = new JButton("Search");
		btnFlightMgr = new JButton("Flight Manager");
		btnTicketMgr = new JButton("Ticket Manager");
		btnTicketCancel = new JButton("Cancel Selected Ticket");
		btnTicketBook = new JButton("Book Ticket");
		btnFlightAdd = new JButton("Add Flight");
		btnFlightLoad = new JButton("Load flights from file");
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
		
		pnlTicket.add(btnSearchT);
		pnlTicket.add(btnTicketCancel);
		
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
		
		btnSearchF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	strArray = new String[2];
        		search = new SearchGUI(actionListener,0);
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
		
		btnSearchT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	strArray = new String[2];
        		search = new SearchGUI(actionListener,1); //ticket search has more search options
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
            	//TODO add flight to database
            	JFrame addFlight = new AddFlightGUI();
            	addFlight.setVisible(true);
            }
        });
		
		btnFlightLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//TODO load flights from file
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
		
	}
	
	//main method for testing purposes:
	
	public static void main(String[] args)
	{
		JFrame f = new AdminGUI();
	    f.setVisible(true);	
	}
	
}
