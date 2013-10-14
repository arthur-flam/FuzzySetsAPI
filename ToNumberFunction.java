import java.util.regex.*;
public class ToNumberFunction {
	// a number is in form of xxxx.xxxx x:one digital 
	static private Pattern pattern = Pattern.compile("[0-9]+\\.?[0-9]*");

	public static double stringToDouble(String s) throws NumberFormaException {	
		
		
		if (!pattern.matcher(s).matches())
			throw new NumberFormaException();
		
		return Double.valueOf(s);
	}
	
}
