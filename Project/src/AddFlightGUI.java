import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Brendon
 * 
 */
public class AddFlightGUI extends JFrame {

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
	JLabel lblFlightDate;
	JLabel lblFlightTime;
	JLabel lblFlightSrc;
	JLabel lblFlightDest;
	JLabel lblFlightNum;
	JLabel lblFlightDur;
	JButton btnAddFlight;
	JButton btnCancel;
	
	Container c;
	
	
	public AddFlightGUI()
	{
		txtFlightDate = new JTextField(10);
		txtFlightTime = new JTextField(10);
		txtFlightSrc = new JTextField(10);
		txtFlightDest = new JTextField(10);
		txtFlightNum = new JTextField(10);
		txtFlightDur = new JTextField(10);
		lblFlightDate = new JLabel(" Date:");
		lblFlightTime = new JLabel(" Time:");
		lblFlightSrc = new JLabel(" Source:");
		lblFlightDest = new JLabel(" Destination:");
		lblFlightNum = new JLabel(" Number:");
		lblFlightDur = new JLabel(" Duration:");
		btnAddFlight = new JButton("Add Flight");
		btnCancel = new JButton("Cancel");
		JPanel pnlInput = new JPanel(new GridBagLayout());
		JPanel pnlBtns = new JPanel();
		GridBagConstraints gC = new GridBagConstraints();
        //natural height, maximum width
        //gC.fill = GridBagConstraints.HORIZONTAL;
		c = getContentPane();
		
		
		lblFlightDate.setLabelFor(txtFlightDate);
		lblFlightTime.setLabelFor(txtFlightTime);
		lblFlightSrc.setLabelFor(txtFlightSrc);
		lblFlightDest.setLabelFor(txtFlightDest);
		lblFlightNum.setLabelFor(txtFlightNum);
		lblFlightDur.setLabelFor(txtFlightDur);
		
		gC.gridx = 0;
		gC.gridy = 0;
		gC.gridwidth = 4;
		pnlInput.add(new Label("Add Flight - Please enter flight information:"),gC);
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

		
		pnlBtns.add(btnAddFlight);
		pnlBtns.add(btnCancel);
		
		c.add(pnlInput, BorderLayout.CENTER);
		c.add(pnlBtns, BorderLayout.SOUTH);
		c.setBounds(getBounds());
		this.setPreferredSize(new Dimension(400, 200));
		this.pack();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	//main method for testing purposes:
	public static void main(String[] args)
	{
		JFrame f = new AddFlightGUI();
	    f.setVisible(true);
	    
		
	}
	
}
