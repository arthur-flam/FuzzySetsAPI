import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class tconorm_lukas implements tnorm{
	public double compute(double x, double y){
		return Math.min(1, x+y);
	};
}