import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorWindow {
	
	public static void go(String sms){
		JFrame f=new JFrame("NAN!");
		
		JLabel l=new JLabel(sms);
		
		f.add(l);
		
		f.setSize(190,100);
		
		f.setLocation(500,300);
		
		f.setVisible(true);
		//
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
