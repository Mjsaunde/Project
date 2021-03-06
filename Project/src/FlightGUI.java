import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

/**
 * 
 * @author Brendon
 * 
 */
public class FlightGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtFlightDate;
	JTextField txtFlightTime;
	JTextField txtFlightSrc;
	JTextField txtFlightDest;
	JTextField txtFlightNum;
	JTextField txtFlightDur;
	JTextField txtPassName;
	JTextField txtPassLName;
	JTextField txtPassBday;
	JTextField txtFlightAvail;
	JTextField txtFlightPrice;
	JLabel lblFlightDate;
	JLabel lblFlightTime;
	JLabel lblFlightSrc;
	JLabel lblFlightDest;
	JLabel lblFlightNum;
	JLabel lblFlightDur;
	JLabel lblPassName;
	JLabel lblPassLName;
	JLabel lblPassBday;
	JLabel lblFlightAvail;
	JLabel lblFlightPrice;
	JButton btnFlightBook;
	JButton btnCancel;
	Flight flight;
	
	Container c;
	
	
	/**
	 * Constructor and listeners
	 * @param obj
	 * @param flight
	 */
	public FlightGUI(GUI obj, Flight flight)
	{
		this.flight = flight;
		txtFlightDate = new JTextField(10);
		txtFlightTime = new JTextField(10);
		txtFlightSrc = new JTextField(10);
		txtFlightDest = new JTextField(10);
		txtFlightNum = new JTextField(10);
		txtFlightDur = new JTextField(10);
		txtPassName = new JTextField(10);
		txtPassLName = new JTextField(10);
		txtFlightPrice = new JTextField(10);
		txtFlightAvail = new JTextField(10);
		txtPassBday = new JTextField("YYYYMMDD",10);
		lblFlightDate = new JLabel(" Date:");
		lblFlightTime = new JLabel(" Time:");
		lblFlightSrc = new JLabel(" Source:");
		lblFlightDest = new JLabel(" Destination:");
		lblFlightNum = new JLabel(" Number:");
		lblFlightDur = new JLabel(" Duration:");
		lblPassName = new JLabel(" First Name:");
		lblPassLName = new JLabel(" Last Name:");
		lblPassBday = new JLabel(" Date of Birth:");
		lblFlightAvail = new JLabel(" Available Seats:");
		lblFlightPrice = new JLabel(" Price:");
		btnFlightBook = new JButton("Book Flight");
		btnCancel = new JButton("Cancel");
		JPanel pnlInput = new JPanel(new GridBagLayout());
		JPanel pnlBtns = new JPanel();
		GridBagConstraints gC = new GridBagConstraints();
        //natural height, maximum width
        //gC.fill = GridBagConstraints.HORIZONTAL;
		c = getContentPane();
		
		txtFlightDate.setEditable(false);
		txtFlightTime.setEditable(false);
		txtFlightSrc.setEditable(false);
		txtFlightDest.setEditable(false);
		txtFlightNum.setEditable(false);
		txtFlightDur.setEditable(false);
		txtFlightPrice.setEditable(false);
		txtFlightAvail.setEditable(false);
		
		lblFlightDate.setLabelFor(txtFlightDate);
		lblFlightTime.setLabelFor(txtFlightTime);
		lblFlightSrc.setLabelFor(txtFlightSrc);
		lblFlightDest.setLabelFor(txtFlightDest);
		lblFlightNum.setLabelFor(txtFlightNum);
		lblFlightDur.setLabelFor(txtFlightDur);
		lblPassName.setLabelFor(txtPassName);
		lblPassLName.setLabelFor(txtPassLName);
		lblPassBday.setLabelFor(txtPassBday);
		
		gC.gridx = 1;
		gC.gridy = 0;
		gC.gridwidth = 2;
		pnlInput.add(new Label("Flight Information:"),gC);
		gC.gridx = 0;
		gC.gridy = 1;
		gC.gridwidth = 1;
		pnlInput.add(lblFlightDate,gC);
		gC.gridx = 1;
		gC.gridy = 1;
		pnlInput.add(txtFlightDate,gC);
		gC.gridx = 2;
		gC.gridy = 1;
		pnlInput.add(lblFlightTime,gC);
		gC.gridx = 3;
		gC.gridy = 1;
		pnlInput.add(txtFlightTime,gC);
		gC.gridx = 0;
		gC.gridy = 2;
		pnlInput.add(lblFlightSrc,gC);
		gC.gridx = 1;
		gC.gridy = 2;
		pnlInput.add(txtFlightSrc,gC);
		gC.gridx = 2;
		gC.gridy = 2;
		pnlInput.add(lblFlightDest,gC);
		gC.gridx = 3;
		gC.gridy = 2;
		pnlInput.add(txtFlightDest,gC);
		gC.gridx = 0;
		gC.gridy = 3;
		pnlInput.add(lblFlightNum,gC);
		gC.gridx = 1;
		gC.gridy = 3;
		pnlInput.add(txtFlightNum,gC);
		gC.gridx = 2;
		gC.gridy = 3;
		pnlInput.add(lblFlightDur,gC);
		gC.gridx = 3;
		gC.gridy = 3;
		pnlInput.add(txtFlightDur,gC);
		gC.gridx = 0;
		gC.gridy = 4;
		pnlInput.add(lblFlightAvail,gC);
		gC.gridx = 1;
		gC.gridy = 4;
		pnlInput.add(txtFlightAvail,gC);
		gC.gridx = 2;
		gC.gridy = 4;
		pnlInput.add(lblFlightPrice,gC);
		gC.gridx = 3;
		gC.gridy = 4;
		pnlInput.add(txtFlightPrice,gC);
		gC.insets = new Insets(20,0,0,0);
		gC.gridx = 1;
		gC.gridy = 6;
		gC.gridwidth = 2;
		pnlInput.add(new Label("Passenger Information:"),gC);
		gC.insets = new Insets(0,0,0,0);
		gC.gridx = 0;
		gC.gridy = 7;
		gC.gridwidth = 1;
		pnlInput.add(lblPassName,gC);
		gC.gridx = 1;
		gC.gridy = 7;
		pnlInput.add(txtPassName,gC);
		gC.gridx = 2;
		gC.gridy = 7;
		pnlInput.add(lblPassLName,gC);
		gC.gridx = 3;
		gC.gridy = 7;
		pnlInput.add(txtPassLName,gC);
		gC.gridx = 0;
		gC.gridy = 8;
		pnlInput.add(lblPassBday,gC);
		gC.gridx = 1;
		gC.gridy = 8;
		pnlInput.add(txtPassBday,gC);

		
		
		pnlBtns.add(btnFlightBook);
		pnlBtns.add(btnCancel);
		
		c.add(pnlInput, BorderLayout.CENTER);
		c.add(pnlBtns, BorderLayout.SOUTH);
		c.setBounds(getBounds());
		this.setPreferredSize(new Dimension(450, 300));
		this.pack();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		populateData();
		
		btnFlightBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		//TODO to add, needs to check out booking so multiple people can not book the flight
            	Passenger pass = new Passenger(txtPassName.getText(),txtPassLName.getText(),new Date(txtPassBday.getText()));
            	obj.bookFlight(pass,flight);
            }
        });
		
		btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//close the window
            	setVisible(false);
            	dispose();
            }
        });
		
		txtPassBday.addMouseListener(new MouseAdapter()
	    {
	        public void mouseClicked(MouseEvent e)
	        {
	            if(txtPassBday.getText().equals("YYYYMMDD"))
	            {
	            	txtPassBday.setText("");
	                repaint();
	                revalidate();
	            }           
	        }
	    });
	}
	
	/**
	 * 
	 */
	private void populateData()
	{
		txtFlightDate.setText(flight.getFlightDate().toString());
		txtFlightTime.setText(flight.getFlightTime().toString());
		txtFlightSrc.setText(flight.getFlightSource());
		txtFlightDest.setText(flight.getFlightDestination());
		txtFlightNum.setText(flight.getFlightNumber().toString());
		txtFlightDur.setText(flight.getFlightDuration().toString());
		txtFlightPrice.setText(flight.getFlightPrice().toString());
		txtFlightAvail.setText(flight.getFlightSeatsAvailible().toString());
	}
	
	
	//main method for testing purposes:
	/*
	public static void main(String[] args)
	{
		JFrame f = new FlightGUI();
	    f.setVisible(true);
	}
	*/
}
