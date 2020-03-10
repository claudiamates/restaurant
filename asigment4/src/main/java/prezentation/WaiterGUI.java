package prezentation;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WaiterGUI extends JFrame{

	private JTextField orderIDTextField;
	private JTextField tableTextField;
	public JComboBox menuComboBox;
	private JButton orderButton;
	private JButton viewButton;
	private JButton billButton;
	//private J
	
	public WaiterGUI()  {
		 
		this.setBounds(100,100,415,400);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  getContentPane().setLayout(null);
		  
		  JLabel orderIDLabel = new JLabel("Order");
		  orderIDLabel.setBounds(114, 32, 84, 14);
		  getContentPane().add(orderIDLabel);
		  
		  orderIDTextField = new JTextField();
		  orderIDTextField.setBounds(210, 32, 162, 20);
		  getContentPane().add(orderIDTextField);
		  
		  JLabel tableLabel = new JLabel("Table");
		  tableLabel.setBounds(114, 54, 84, 14);
		  getContentPane().add(tableLabel);
		  
		  tableTextField = new JTextField();
		  tableTextField.setBounds(210, 54, 162, 20);
		  getContentPane().add(tableTextField);
		  
		  JLabel menuLabel = new JLabel("Choose");
		  menuLabel.setBounds(114, 85, 84, 14);
		  getContentPane().add(menuLabel);
		  
		  menuComboBox = new JComboBox();
		  menuComboBox.setBounds(210, 85, 162, 20);
		  getContentPane().add(menuComboBox);
		  
		  orderButton = new JButton("Create order");
		  orderButton.setBounds(114, 137, 162, 20);
		  getContentPane().add( orderButton);
		  
		  viewButton = new JButton("View orders");
		  viewButton.setBounds(114, 157, 162, 20);
		  getContentPane().add( viewButton);
		  
		  billButton = new JButton("Create bill");
		  billButton.setBounds(114, 177, 162, 20);
		  getContentPane().add( billButton);
	}
	public void addOrderActionListener(final ActionListener actionListener)
	  {
		  orderButton.addActionListener(actionListener);
	  }
	
	public void addViewActionListener(final ActionListener actionListener)
	  {
		  viewButton.addActionListener(actionListener);
	  }
	
	public void addBillActionListener(final ActionListener actionListener)
	  {
		  billButton.addActionListener(actionListener);
	  }
	
	public String getOrder() {
		return orderIDTextField.getText();
	}
	
	public String getTable() {
		return tableTextField.getText();
	}
	
}

