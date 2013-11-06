import java.util.ArrayList;

/**
 * Represents a set of fuzzy sets, useful to handle a group of them 
 */
public class data{
	public ArrayList<set> sets = new ArrayList<set>();

	public String toString(){
		String out = "Ensembles:";
		for(set s : sets){
			out = out + "\n* "+s.name + " (" + s.length() + " points entre "+s.min+" et "+s.max+")";
		}	
		return out;	
	}
}
