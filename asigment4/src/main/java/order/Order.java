package order;

import java.util.Date;

public class Order {

	private int orderID;
	private int table;
	private Date date;
	
	public void setID(int id) {
		this.orderID=id;
	}
	
	public void setTable(int nr) {
		this.table=nr;
	}
	
	@Override
	public int hashCode() {
		return (orderID+table)/3;
	}
}
