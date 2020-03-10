package order;

public abstract class MenuItem {

	public void add(MenuItem menuComponent) {
       // throw new UnsupportedOperationException();
    }
	
    public void remove(MenuItem menuComponent) {
       // throw new UnsupportedOperationException();
    }
    
    public MenuItem getChild(int i) {
		return null;
        //throw new UnsupportedOperationException();
    }
    
    public String getName() {
		return null;
        //throw new UnsupportedOperationException();
    }
    
	public abstract int computePrice();
	
}

