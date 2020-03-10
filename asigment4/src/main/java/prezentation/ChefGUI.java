package prezentation;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChefGUI extends JFrame implements Observer {
	
	private JLabel messageLabel;
	
	public ChefGUI() {
		this.setBounds(500,100,315,300);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  getContentPane().setLayout(null);
		  
		  messageLabel = new JLabel("Waiting");
			messageLabel.setBounds(50, 120, 200, 16);
			getContentPane().add(messageLabel);
	}

	
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
			final Runnable runnable = new Runnable() {

				
				public void run() {
					messageLabel.setText("New Order");
					messageLabel.setVisible(true);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						//messageLabel.setVisible(false);
						messageLabel.setText("Waiting");
					}
				}
			};
			Thread thread = new Thread(runnable);
			thread.start();
			

		}
	

}
