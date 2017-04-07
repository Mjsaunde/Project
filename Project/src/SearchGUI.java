import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * 
 * @author Brendon
 * Stores a string array with search field and criteria
 */
public class SearchGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JComboBox<String> boxSearchType;
	JTextField txtSearchCrit;
	JButton btnOk;
	JButton btnCancel;
	String[] strArray; //store search criteria
	
	Container c;
	
	
	/**
	 * 
	 * @param actionListener
	 * @param mode is 0 when used for flights, 1 when used for tickets
	 */
	public SearchGUI(GUI obj, int mode)
	{
		boxSearchType  = new JComboBox<String>();
		txtSearchCrit = new JTextField("YYYYMMDD",10);
		btnOk = new JButton("Search");
		btnCancel = new JButton("Cancel");
		strArray = new String[2];
		JPanel pnlInput = new JPanel(new GridBagLayout());
		JPanel pnlBtns = new JPanel();
		GridBagConstraints gC = new GridBagConstraints();
		c = getContentPane();
		
		boxSearchType.addItem("date");
		boxSearchType.addItem("source");
		boxSearchType.addItem("destination");
		boxSearchType.addItem("flight number");

		if (mode == 1)
		{
			boxSearchType.addItem("First Name");
			boxSearchType.addItem("Last Name");
			boxSearchType.addItem("Ticket ID");
		}
		
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

		
		pnlBtns.add(btnOk);
		pnlBtns.add(btnCancel);
		
		c.add(pnlInput, BorderLayout.CENTER);
		c.add(pnlBtns, BorderLayout.SOUTH);
		c.setBounds(getBounds());
		this.setPreferredSize(new Dimension(400, 200));
		this.pack();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//btnOk.addActionListener(actionListener);
		btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	obj.searchCriteria(getQuery());
            	//close the window
            	setVisible(false);
            	dispose();
            }
        });
		
		btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	strArray = null;
            	//close the window
            	setVisible(false);
            	dispose();
            }
        });
		
		txtSearchCrit.addMouseListener(new MouseAdapter()
	    {
	        public void mouseClicked(MouseEvent e)
	        {
	            if(txtSearchCrit.getText().equals("YYYYMMDD"))
	            {
	            	txtSearchCrit.setText("");
	                repaint();
	                revalidate();
	            }           
	        }
	    });
		
	}
	
	public String[] getQuery()
	{
		strArray[0] = boxSearchType.getSelectedItem().toString();
    	strArray[1] = txtSearchCrit.getText();
    	setVisible(false);
		return strArray;
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
