import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class tconorm_proba implements tnorm{
	public double compute(double x, double y){
		return x+y-x*y;
	};
}