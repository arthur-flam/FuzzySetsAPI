import java.util.ArrayList;
import java.util.Arrays;

public class function_identity implements IMapping{
	public double compute(double x){
		return x;
	};
	public ArrayList<Double> reverse(double x){
		return new ArrayList<Double>(Arrays.asList(x));
	};
	public String toString(){
		return "identity";
	};
}