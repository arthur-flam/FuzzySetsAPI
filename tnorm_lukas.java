import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class tnorm_lukas implements tnorm{
	public double compute(double x, double y){
		return Math.max(0, x+y-1);
	};
}