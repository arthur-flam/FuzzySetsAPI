import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
/**
 * this class will drawing a window for x & y to initialize 
 * @author group of Arthur & Wenjun 
 *
 */
public class XYSet_window {

	private JFrame frame;
	private ArrayList<HashMap<JTextField,JTextField>> listsetT=new ArrayList<HashMap<JTextField,JTextField>>();
	
	public XYSet_window(final int nbp,final int nbs){
		this.go(nbp,nbs);
	}	
	private void go(final int nbp,final int nbs){
		
		
		GridLayout newlayout = new GridLayout(nbp,4);
		frame=new JFrame();
		JPanel panel=new JPanel();
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		JButton button=new JButton("Continue");
		
		//the {x1=..,y1=..,x2=..,y2=...}
		HashMap<JTextField,JTextField> xys;
		
		for(int j=1;j<=nbs;j++){
			xys=new HashMap<JTextField,JTextField>();
			JPanel paneli=new JPanel();
			
			panel.add(new JLabel("Sef"+j));
			for(int i=1;i<=nbp;i++){
				
				paneli.setLayout(newlayout);
				JTextField x=new JTextField(7);
				JTextField y=new JTextField(7);
			    xys.put(x, y);
				
			    JPanel p=new JPanel();
				paneli.add(new JLabel("x : "));
			    paneli.add(p);
			    p.add(x);
			 
			    p=new JPanel();
				paneli.add(new JLabel("y : "));
				paneli.add(p);
			    p.add(y);	
			}
			
			
			panel.add(paneli);
			this.listsetT.add(xys);
	    }
		
		button.addActionListener(new clic());
	
		panel.add(button);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350,47*nbp*nbs +20);
		frame.setVisible(true);
		frame.setLocation(400,100);
	}
	
	
	private class clic implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//here to add the method for testing x and y are numbers 
			try {
				ArrayList<set> sets=null;
				
				sets=getSet();
				
				System.out.print(sets);
				new MainWindow(sets);
				
				frame.dispose();
			}
			catch (NumberFormaException e){
				ErrorWindow.go(e.getMessage());
			}
			finally {
				//
			}
					
		}
		/**
		 * 
		 * @return a list of sefs in form ArrayList
		 * @throws NumberFormaException
		 */
		private ArrayList<set> getSet()throws NumberFormaException{
			
			ArrayList<set> listS=new ArrayList<set>();
			
			double x,y;
			
			int name=1;
			
			for(HashMap<JTextField,JTextField> xys : listsetT){
				
				ArrayList<element> elements=new ArrayList<element>();
				double min=10;
				double max=-10;
				for(Entry<JTextField, JTextField> xy :xys.entrySet()){
					
					x=ToNumberFunction.stringToDouble(xy.getKey().getText());
					y=ToNumberFunction.stringToDouble(xy.getValue().getText());
					
					min=(min<x?min:x);
					max=(max>x?max:x);
					elements.add(new element(x,y));
				}
				
				set s=new set(elements,min,max,"sef"+name++); 
				listS.add(s);
			}
			
			return listS;
		}
	}
}
