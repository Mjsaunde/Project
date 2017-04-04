import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Brendon
 * 
 */
public class SearchGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox<String> boxSearchType;
	JTextField txtSearchCrit;
	JButton btnAddFlight;
	JButton btnCancel;
	
	Container c;
	
	
	public SearchGUI()
	{
		boxSearchType  = new JComboBox<String>();
		txtSearchCrit = new JTextField(10);
		btnAddFlight = new JButton("Add Flight");
		btnCancel = new JButton("Cancel");
		JPanel pnlInput = new JPanel(new GridBagLayout());
		JPanel pnlBtns = new JPanel();
		GridBagConstraints gC = new GridBagConstraints();
		c = getContentPane();
		
		boxSearchType.addItem("date");
		boxSearchType.addItem("source");
		boxSearchType.addItem("destination");
		boxSearchType.addItem("flight number");
		//any others?
		
		gC.gridx = 0;
		gC.gridy = 0;
		gC.gridwidth = 4;
		pnlInput.add(new Label("Search Flight - Please enter criteria:"),gC);
		gC.gridx = 0;
		gC.gridy = 1;
		gC.gridwidth = 1;
		pnlInput.add(boxSearchType,gC);
		gC.insets = new Insets(0,10,0,0);
		gC.gridx = 1;
		gC.gridy = 1;
		pnlInput.add(txtSearchCrit,gC);

		
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
	/*
	public static void main(String[] args)
	{
		JFrame f = new SearchGUI();
	    f.setVisible(true);	
	}
	*/
}
