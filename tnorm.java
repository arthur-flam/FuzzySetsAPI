import java.util.ArrayList;

/**
 * Represents a t-norm or a t-conorm.
 */
public interface tnorm {
	/**
	 * Computes the (t)conorm of two values
	 * 
	 * @param x first belonging degree
	 * @param y second belonging degree
	 * @return a belonging degree
	 */
	public abstract double compute(double x, double y);

}
