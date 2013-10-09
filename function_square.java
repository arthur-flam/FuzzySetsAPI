import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class function_square implements IMapping{
	public double compute(double x){
		return x*x;
	};
	public ArrayList<Double> reverse(double x){
		if(x<0){
		return new ArrayList<Double>();
		} else {
		return new ArrayList<Double>(Arrays.asList(Math.sqrt(x), -Math.sqrt(x)));
		}
	};
	public String toString(){
		return "square";
	};
}