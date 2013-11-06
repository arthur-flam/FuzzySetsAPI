import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
public class OpenFileOrManually_windows {
	private JFrame frame;
	private JTextField openFileName;
	private JTextField nbPoints;
	private JTextField nbset;
	
	
	public OpenFileOrManually_windows(){
		this.go();
	}
	private void go(){
		
		frame=new JFrame();
		JPanel panelFile=new JPanel(),panelManu=new JPanel();
		JPanel panelFile1=new JPanel(),panelManu1=new JPanel();
		JPanel panelFile2=new JPanel(),panelManu2=new JPanel();
		
		JLabel labelFile=new JLabel("  From a file:"),labelManu=new JLabel("  Manually:");
		JLabel fileName=new JLabel("File name:     "),nbP=new JLabel("Number of points: "),nbS=new JLabel("Number of sef:");
		this.openFileName=new JTextField(20);
		this.nbPoints=new JTextField(5);
		this.nbset=new JTextField(5);
		JButton validF=new JButton("OK");
		JButton validM=new JButton("OK");
		
		validF.addActionListener(new fileLisener());
		validM.addActionListener(new manuLisener());
		
		//JPane use FlowLayout by default
		panelFile1.add(fileName);
		panelFile1.add(this.openFileName);
		panelFile1.add(validF);
		// change the way of layout
		panelFile.setLayout(new BoxLayout(panelFile,BoxLayout.Y_AXIS));
		panelFile2.setLayout(new BorderLayout());
		panelFile2.add(BorderLayout.WEST,labelFile);
		// put the two panels into up panel  
		panelFile.add(panelFile2);
		panelFile.add(panelFile1);
		// the fin for file part
		
		//for manually 
		panelManu1.add(nbP);
		panelManu1.add(this.nbPoints);
		panelManu1.add(nbS);
		panelManu1.add(this.nbset);
		panelManu1.add(validM);
		// change the way of layout
		panelManu.setLayout(new BoxLayout(panelManu,BoxLayout.Y_AXIS));
		panelManu2.setLayout(new BorderLayout());
		panelManu2.add(BorderLayout.WEST,labelManu);
		panelManu.add(panelManu2);
		panelManu.add(panelManu1);
		// fin 
		
		frame.getContentPane().add(BorderLayout.NORTH,panelFile);
		frame.getContentPane().add(BorderLayout.SOUTH,panelManu);
		
		frame.setSize(400,160);
		frame.setVisible(true);
		frame.setLocation(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	class fileLisener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		// 还需检测 路径是否有效	
			
			String fileName=openFileName.getText();	
			
			try { 
				ArrayList<set> setss=new Read_writeFile().reading(fileName);
				new MainWindow(setss);
				frame.dispose();
 
		} catch (FileNotFoundException e) {
			ErrorWindow.go("No file found !");
			
		}catch(IOException e){
			e.printStackTrace();
		}
		catch (NumberFormaException e){
			ErrorWindow.go(e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			
		}
		
	}
	
	class manuLisener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//输入值时候为空或者无效数字
			//get #points & # sef from the windows 
			String nbp=nbPoints.getText();
			String nbs=nbset.getText();
			
			new XYSet_window(Integer.valueOf(nbp),Integer.valueOf(nbs));
			frame.dispose();
			
			
		}
		
	}
	
}
