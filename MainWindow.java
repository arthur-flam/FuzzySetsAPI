import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import org.jfree.ui.RefineryUtilities;

public class MainWindow {
    
	private String s1="firstfamily",s2="secondfamily",s3="thirdfamily";
	private int select,i;
	private ArrayList<set> setss;
	public MainWindow(ArrayList<set> sets){
		setss=sets;
    	//this.go(sets);
		this.set_window();
    }
    
 //private void go(ArrayList<set> sets){
 private void set_window(){ 
    	JFrame frame=new JFrame("Functions");
    	JLabel l=new JLabel("Value at x =");
    	JTextField x=new JTextField(10);
    	JButton bV=new JButton ("ok");
    	JButton bto=new JButton("Draw the original sefs");
    	JButton btc=new JButton("complementary");
    	JButton btf1=new JButton("f(x)=x^2 verifier Ex13");
    	JButton btf2=new JButton("f(x)=???");
    	
    	JRadioButton [] f=new JRadioButton[3];
    	f[1]=new JRadioButton(s2);
    	f[2]=new JRadioButton(s3);
    	f[0]=new JRadioButton(s1,true);
    	
    	for (i=0;i<3;i++)
	    	f[i].addActionListener(new ActionListener() {     // 捕获单选按钮被选中的事件
	    		public void actionPerformed(ActionEvent e) {
	    			select=i+1;
	    		}
	    	});
    	
    	ButtonGroup families=new ButtonGroup();
    	for (i=0;i<3;i++)
    		families.add(f[i]);
    	
    	JButton [] buttons=new JButton[6];
    	
    	buttons[0]=new JButton("T-conorme");
    	buttons[1]=new JButton("T-norme");
    	buttons[2]=new JButton(" save  ");
    	
    	JPanel p1=new JPanel();
    	JPanel p11=new JPanel();
    	p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
    	
    	p11.add(l);
    	p11.add(x);
    	p11.add(bV);
    	p1.add(bto);
    	p1.add(btc);
    	p1.add(p11);
    	
    	JPanel p2=new JPanel();
    	JPanel p21=new JPanel();
    	JPanel p22=new JPanel();
    	p21.setLayout(new BoxLayout(p21,BoxLayout.Y_AXIS));
    	for (i=0;i<3;i++)
    		p21.add(f[i]);
    	
    	p2.add(p21);
    	p2.add(p22);
    	
    	JPanel p3=new JPanel();
    	
    	p3.add(btf1);
    	p3.add(btf2);
    	
    	JPanel p=new JPanel();
    	
    	p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
    	
    	p.add(p1);
    	p.add(p2);
    	p.add(p3);
    	
    	frame.add(p);
    	frame.setSize(500,400);
    	frame.setLocation(400, 400);
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	btf1.addActionListener(new foncxq());
    }
 
    class foncxq implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			element a = new element(1, 0);
			element c = new element(2, 1);
			element e1 = new element(3, 0);
		
			System.out.println("2. Création d'un ensemble");
			ArrayList<element> elementsA = new ArrayList<element>(Arrays.asList(a,c,e1));
			double min=-1.5, max=3;
			set SetA = new set(elementsA, min, max, "SetA");
			
		
			set s=set.apply(SetA, new function_square(), 0.1);
			final Drawing demo = new Drawing(" f(x)=x^2" ,s);
		    demo.pack();
		    RefineryUtilities.centerFrameOnScreen(demo);
		    demo.setVisible(true);
		    demo.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			
		}

	}

}
