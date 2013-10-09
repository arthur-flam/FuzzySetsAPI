import java.util.Arrays;
import java.util.ArrayList;

public class fuzzySetsAPI{
    public static void main(String[] args){
    	System.out.println("1. Initialisation des points");
    	// a)
		// element a = new element(-1, 0);
		// element b = new element(-0.99, 0.01);
		// element c = new element(0, 1);
		// element d = new element(1.99, 0.005);
		// element e = new element(2, 0);
    	// b)
		element a = new element(1, 0);
		element c = new element(2, 1);
		element e = new element(3, 0);
		System.out.println("Premier point :");
		System.out.println(a);
		System.out.println("***\n");

		System.out.println("2. Création d'un ensemble");
		ArrayList<element> elementsA = new ArrayList<element>(Arrays.asList(a,c,e));
		double min=-1.5, max=3;
		set SetA = new set(elementsA, min, max, "SetA");
		System.out.println(SetA);

		System.out.println("3. Valeur aux points :");
		System.out.println("0   :"+SetA.valueAt(0));
		System.out.println("0.5 :"+SetA.valueAt(0.5));
		System.out.println("1   :"+SetA.valueAt(1));
		System.out.println("1.5 :"+SetA.valueAt(1.5));
		System.out.println("2   :"+SetA.valueAt(2));
		System.out.println("***\n");

		System.out.println("4. Collection d'ensembles");
		data data = new data(); 
		data.sets.add(SetA);
		System.out.println(data);
		System.out.println("***\n");


		System.out.println("5. Complémentaire :");
		set SetB = set.complementaire(SetA);
		data.sets.add(SetB);
		System.out.println(SetB);
		System.out.println("***\n");

		System.out.println("4. Fonctions");
		//IMapping f = new function_identity();
		IMapping f = new function_square();
		set SetC = set.apply(SetA, f, 0.1);
		data.sets.add(SetC);
		System.out.println(SetC);
		System.out.println(data);
		System.out.println("***\n");

    }
}
