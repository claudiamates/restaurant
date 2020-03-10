package order;

public class BaseProduct extends MenuItem {
	
	   private String item;
	   private int price;

		
		public BaseProduct(String item, int price) {
			this.item=item;
			this.price=price;
		}
		@Override
		public int computePrice() {
			return price;
		}
		
		 public String getName() {
		        return item;
		    }

	}
