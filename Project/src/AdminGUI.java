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
	JButton btnSearch;
	JButton btnFlightData; //to book flight
	
	JButton btnTicketCancel;
	JButton btnTicketBook;
	JButton btnFlightAdd;
	JButton btnFlightLoad;
	
	Container c;
	
	
	public AdminGUI()
	{
		lstDisplay  = new JList<String>();
		btnSearch = new JButton("Add Flight");
		btnFlightData = new JButton("Flight Data");
		JPanel pnlBtns = new JPanel();
		JPanel pnlTicket = new JPanel(); //ticket manager
		JPanel pnlFlight = new JPanel(); //flight manager
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
		
		btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            }
        });
		
		btnFlightData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
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
