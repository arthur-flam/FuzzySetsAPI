import java.util.ArrayList;

public interface tnorm {
	/**
	 * Calcule la (t)conorme de deux valeurs
	 * 
	 * @param x valeur réelle 
	 * @param y valeur réelle 
	 * @return image de x par la (co)norme
	 */
	public abstract double compute(double x, double y);

}
