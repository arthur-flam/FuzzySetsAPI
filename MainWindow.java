import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class MainWindow {
    
	private String s1="firstfamily",s2="secondfamily",s3="thirdfamily";
	private int select,i;
	public MainWindow(){
		//ArrayList<set> sets
    	//this.go(sets);
		this.go();
    }
    
  //  private void go(ArrayList<set> sets){
	 private void go(){ 
    	JFrame frame=new JFrame("Functions");
    	JLabel l=new JLabel("Value at x =");
    	JTextField x=new JTextField(10);
    	JButton bV=new JButton ("ok");
    	JButton bto=new JButton("Draw the original sefs");
    	JButton btc=new JButton("complementary");
    	JButton btf1=new JButton("f(x)=x^2");
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
    }
    
    
    
//    public static void main(String[] arg){
//    	new MainWindow();
//    }
}
