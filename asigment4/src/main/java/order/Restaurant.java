package order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import prezentation.AdministratorGUI;
import prezentation.ChefGUI;
import prezentation.WaiterGUI;

public class Restaurant extends Observable{

	private ArrayList<MenuItem> menuItem;
	private Order order;
	private Map<Order,ArrayList<MenuItem>> menuMap;
	private WaiterGUI waiter;
	private AdministratorGUI admin;
	private ChefGUI chef;
	 int i=0;
	public void start() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
        menuItem=new ArrayList<MenuItem>();
        order = new Order();
        waiter = new WaiterGUI();
        admin = new AdministratorGUI();
        chef = new ChefGUI();
        menuMap = new HashMap();
        
        waiter.setVisible(true);
		admin.setVisible(true);
        chef.setVisible(true);
        
        initializeActionListeners();
   
	}
		
	public void initializeActionListeners() {
		admin.addCreateBaseActionListener(e->{
			final String item = admin.getBaseItem();
			final int price = Integer.parseInt(admin.getBasePrice());
			
			//BaseProduct baseProd = new BaseProduct(item,price);
			menuItem.add(new BaseProduct(item,price));
			waiter.menuComboBox.addItem(item);
			//i++;
			System.out.println(menuItem.get(i++).getName());
		});
		
		admin.addCreateCompositeActionListener(e->{
			final String item1 = admin.getBaseItem();
			final String item2 = admin.getBase2Item();
			//final String name =admin.getName();
			final int price1 = Integer.parseInt(admin.getBasePrice());
			final int price2 = Integer.parseInt(admin.getBase2Price());
			
			CompositeProduct compProd = new CompositeProduct(item1 +" si "+ item2);
			compProd.addItem(new BaseProduct(item1,price1));
			compProd.addItem(new BaseProduct(item2,price2));
			menuItem.add(compProd);
			waiter.menuComboBox.addItem(item1 + " si "+ item2);
			//i++;
			
			//System.out.println(i +" " + menuItem.get(i).getName());
		});
		
		admin.addDeleteActionListener(e->{
			final String item1 = admin.getBaseItem();
			final int price1 = Integer.parseInt(admin.getBasePrice());
			
			
			if(item1 != null && price1 != 0) {
				menuItem.remove(new BaseProduct(item1,price1));
			}
		});
		
		admin.addViewActionListener(e->{
			JFrame frame = new JFrame("Menu");
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  JPanel panel = new JPanel();
			  String[] col = new String[3];
			    col[0]="Product";
			    col[1]="Price";
			   String[][] data = null;
			   String[] aux = new String[menuItem.size()];
			   String[] aux1 = new String[menuItem.size()];
			  // aux =menuItem.toArray(aux);
			   for(int j=0; j<menuItem.size(); j++) {
				   aux[j]=menuItem.get(j).getName();
				   aux1[j]=((Integer)menuItem.get(j).computePrice()).toString();
			   }
			  
			DefaultTableModel model = new DefaultTableModel(null,col);
			 for(int j=0; j<aux.length;j++) {
				 model.addRow(new Object[] {aux[j],aux1[j]});
			 }
				  JTable table = new JTable(model);
				  JTableHeader header = table.getTableHeader();
				  JScrollPane pane = new JScrollPane(table);
				  panel.add(pane);
				  frame.add(panel);
				  frame.setUndecorated(true);
				  frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
				  frame.setSize(460,200);
				  frame.setVisible(true); 
			   
		});
		
		waiter.addOrderActionListener(e->{
			final int id = Integer.parseInt(waiter.getOrder());
			final int table = Integer.parseInt(waiter.getTable());
			 String item = (String) waiter.menuComboBox.getSelectedItem();
			 ArrayList<MenuItem> orderdItem= new ArrayList<MenuItem>();
			 for (int j=0;j<menuItem.size();j++) {
				 if((menuItem.get(j).getName()).equals(item)){
						orderdItem.add(menuItem.get(j));

					}	 
			 }
			 //System.out.println(orderdItem.get(0).getName());
			 
			
			if(id > 0 && table > 0) {
				order.setID(id);
				order.setTable(table);
				
				Restaurant r = new Restaurant();
				r.addObserver(chef);
				noty();
				chef.update(r, 0);
				
				menuMap.put(order, orderdItem);	
			}
			
		});
		
		
		waiter.addBillActionListener(e->{
			final int id = Integer.parseInt(waiter.getOrder());
			final int table = Integer.parseInt(waiter.getTable());
			 //String item = (String) waiter.menuComboBox.getSelectedItem();
			
			
			File file = new File("D://poo//tema4//billFile1.txt");
			
			try {
				 if(file.delete()) 
			        { 
			            System.out.println("File deleted successfully"); 
			        } 
			        else
			        { 
			            System.out.println("Failed to delete the file"); 
			        } 
				if (file.createNewFile())
				{
				    System.out.println("File is created!");
				} else {
				    System.out.println("File already exists.");
				}
				
				FileWriter writer = new FileWriter(file);
				
				/*menuMap.forEach((k, v) -> {
					try {
						writer.write("Order nr:");
						writer.write(k + " consumption ");
						 v.forEach(w -> {
							try {
								writer.write(w + ",");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						});
						   // System.out.println();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				   
				});*/
		       /*Set set=menuMap.entrySet();
				Iterator it = set.iterator();
				while(it.hasNext())
				{
					 Map.Entry entry=(Map.Entry)it.next();
					writer.write("Order number:"+entry.getKey()+ "consumed:"+entry.getValue()+"\n");
				}*/
				writer.write("Order number: "+menuMap.keySet().hashCode()+ "consumed: "+menuMap.values().iterator().next().get(0).getName()+"price: "+menuMap.values().iterator().next().get(0).computePrice()+"\n");
				
				//writer.append();
				writer.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		waiter.addViewActionListener(e->{
			JFrame frame = new JFrame("Order");
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  JPanel panel = new JPanel();
			  String[] col = new String[3];
			    col[0]="Key";
			    col[1]="Order";
			    col[2]="Price";
			   String[][] data = null;
			   int aux = 0;
			   String aux1 = new String();
			   String aux2 = new String();
			   aux=menuMap.keySet().hashCode();
			  // aux =menuItem.toArray(aux);
			   for(int j=0; j<menuMap.size(); j++) {
				   aux1=menuMap.values().iterator().next().get(j).getName();
				   aux2=((Integer)menuMap.values().iterator().next().get(j).computePrice()).toString();
			   }
			  
			DefaultTableModel model = new DefaultTableModel(null,col);
			 for(int j=0; j<1;j++) {
				 model.addRow(new Object[] {aux,aux1,aux2});
			 }
				  JTable table = new JTable(model);
				  JTableHeader header = table.getTableHeader();
				  JScrollPane pane = new JScrollPane(table);
				  panel.add(pane);
				  frame.add(panel);
				  frame.setUndecorated(true);
				  frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
				  frame.setSize(460,200);
				  frame.setVisible(true); 
		});
		
	}
	public void noty() {
		setChanged();
		notifyObservers();
	}
	
	
}

