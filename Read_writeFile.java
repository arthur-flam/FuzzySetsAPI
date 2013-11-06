import java.io.*;

import java.util.ArrayList;

import java.util.regex.*;

public class Read_writeFile {
	/**
	 * reading the file in form like:-Borneinf,BorneSup#-x1,y1;x2,y2;...xn,yn
	 * @param name_file of the file we use
	 * @return
	 */
	public  ArrayList<set>  reading(String name_file)throws Exception{
		
		
		ArrayList<set> listS=new ArrayList<set>();
		
		BufferedReader br = null;
		String sCurrentLine;
		br = new BufferedReader(new FileReader(name_file));

		//reading line by line 
		int reference_set=0;
		while ((sCurrentLine = br.readLine()) != null) {
			listS.add(reading_by_syntax(sCurrentLine,reference_set++));
		}
		 

		return listS;
		
	}
	
	/**
	 * if we want to change the syntax this method should be all changed 
	 * @param oneLine
	 * @param reference_set 
	 * @return
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private  set reading_by_syntax(String oneLine,int reference_set) throws NumberFormaException{
		
		//get bounds
		String bounds[]=(oneLine.substring(0,oneLine.indexOf("#"))).split(",");
		
		double boundmin=getBorne(bounds[0]);
		double boundmax=getBorne(bounds[1]);
		
		//get the points
		ArrayList<element> elements=new ArrayList<element>();
		//the ponits seperated by ";"
		String points[]=oneLine.substring(oneLine.indexOf("#")+1).split(";");
		//by running the table points we save each x and y to list elements
		for (String p :points){
			String pXY[]=p.split(",");
			elements.add(new element(ToNumberFunction.stringToDouble(pXY[0]),ToNumberFunction.stringToDouble(pXY[1])));
		}
		
		set s= new set(elements,boundmin,boundmax,"set"+reference_set);
		
		return s;
	}


	private double getBorne(String bound) {
		//reference reguilere
		Pattern pattern = Pattern.compile(".inf");
		Matcher matcher = pattern.matcher(bound);

		return (matcher.matches()?translate_string_to_double(bound):Double.parseDouble(bound));
	}
	
	/**
	 * -inf=-100  inf/+inf=100
	 * @param s
	 * @return
	 */
	private double translate_string_to_double(String s){
		if( (s.trim()).equalsIgnoreCase("-inf"))
			return -100;
		else
			return 100;
		
	}
	
	
	public void writing(ArrayList<set> sets,String name_file_write){
		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name_file_write), "utf-8"));
		    String setsS=get_sets(sets);
		    writer.write(setsS);
		} catch (IOException ex){
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {}
		}
	}
	
	private String get_sets(ArrayList<set> sets){
		String stringSets="",stringElements="";
		for (set s: sets){
			for(element e:s.elements){
				stringElements+=(e.x+","+e.y+";");
			}
			stringSets+=(s.min+","+s.max+"#"+(stringElements.substring(0, stringElements.length()-1))+"\n");
		}
		
		return stringSets;
	}
}
