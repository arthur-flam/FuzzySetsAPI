import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class tnorm_zadeh implements tnorm{
	public double compute(double x, double y){
		return Math.min(x,y);
	};
}