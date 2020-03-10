package prezentation;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdministratorGUI extends JFrame{

	private JTextField baseItemTextField;
	private JTextField basePriceTextField;
	private JTextField base2ItemTextField;
	private JTextField base2PriceTextField;
	private JTextField compositeNameTextField;
	private JButton createBaseButton;
	private JButton createCompositeButton;
	private JButton deleteButton;
	private JButton editButton;
	private JButton viewButton;
	
	public AdministratorGUI() {
		 
		this.setBounds(500,500,415,400);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  getContentPane().setLayout(null);
		  

		  JLabel baseItemLabel = new JLabel("Base Item");
		  baseItemLabel.setBounds(114, 32, 84, 14);
		  getContentPane().add(baseItemLabel);
		  
		  baseItemTextField = new JTextField();
		  baseItemTextField.setBounds(210, 32, 162, 20);
		  getContentPane().add(baseItemTextField);
		  
		  JLabel base2ItemLabel = new JLabel("Base Item 2");
		  base2ItemLabel.setBounds(114, 80, 84, 14);
		  getContentPane().add(base2ItemLabel);
		  
		  base2ItemTextField = new JTextField();
		  base2ItemTextField.setBounds(210, 80, 162, 20);
		  getContentPane().add(base2ItemTextField);
		  
		  JLabel compositeNameLabel = new JLabel("Comp.Name");
		  compositeNameLabel.setBounds(114, 125, 84, 14);
		  getContentPane().add(compositeNameLabel);
		  
		  compositeNameTextField = new JTextField();
		  compositeNameTextField.setBounds(210, 125, 162, 20);
		  getContentPane().add(compositeNameTextField);
		  
		  JLabel basePriceLabel = new JLabel("price");
		  basePriceLabel.setBounds(114, 54, 84, 14);
		  getContentPane().add(basePriceLabel);
		  
		  basePriceTextField = new JTextField();
		  basePriceTextField.setBounds(210, 54, 162, 20);
		  getContentPane().add(basePriceTextField);
		  
		  JLabel base2PriceLabel = new JLabel("price");
		  base2PriceLabel.setBounds(114, 102, 84, 14);
		  getContentPane().add(base2PriceLabel);
		  
		  base2PriceTextField = new JTextField();
		  base2PriceTextField.setBounds(210, 102, 162, 20);
		  getContentPane().add(base2PriceTextField);
		  
		  createBaseButton = new JButton("Create base item");
		  createBaseButton.setBounds(114, 143, 162, 20);
		  getContentPane().add( createBaseButton);
		  
		  createCompositeButton = new JButton("Create composie item");
		  createCompositeButton.setBounds(114, 167, 162, 20);
		  getContentPane().add( createCompositeButton);
		  
		  deleteButton = new JButton("Delete item");
		  deleteButton.setBounds(114, 185, 162, 20);
		  getContentPane().add( deleteButton);
		  
		  editButton = new JButton("Edit item");
		  editButton.setBounds(114, 204, 162, 20);
		  getContentPane().add( editButton);
		  
		  viewButton = new JButton("View Menu");
		  viewButton.setBounds(114, 224, 162, 20);
		  getContentPane().add( viewButton);
	}
	public void addCreateBaseActionListener(final ActionListener actionListener)
	  {
		  createBaseButton.addActionListener(actionListener);
	  }
	
	public void addCreateCompositeActionListener(final ActionListener actionListener)
	  {
		  createCompositeButton.addActionListener(actionListener);
	  }
	
	public void addDeleteActionListener(final ActionListener actionListener)
	  {
		  deleteButton.addActionListener(actionListener);
	  }
	
	public void addEditActionListener(final ActionListener actionListener)
	  {
		  editButton.addActionListener(actionListener);
	  }
	
	public void addViewActionListener(final ActionListener actionListener)
	  {
		  viewButton.addActionListener(actionListener);
	  }
	
	public String getBaseItem() {
		return baseItemTextField.getText();
	}
	
	public String getBase2Item() {
		return base2ItemTextField.getText();
	}
	
	public String getBasePrice() {
		return basePriceTextField.getText();
	}
	
	public String getBase2Price() {
		return base2PriceTextField.getText();
	}
	
	public String getName() {
		return compositeNameTextField.getText();
	}
	
}
