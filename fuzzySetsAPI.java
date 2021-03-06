import java.util.Arrays;
import java.util.ArrayList;

/**
 * This class can be called to test the API.  
 */
public class fuzzySetsAPI{
    public static void main(String[] args){
    	System.out.println("1. Initialisation des points");
		element a = new element(1, 0);
		element c = new element(2, 1);
		element e = new element(3, 0);
		System.out.println("1. Premier point :");
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

		System.out.println("6. Fonctions");
		//IMapping f = new function_identity();
		IMapping f = new function_square();
		set SetC = set.apply(SetA, f, 0.1);
		data.sets.add(SetC);
		System.out.println(SetC);
		System.out.println(data);
		System.out.println("***\n");

		System.out.println("6. Opérations");
		a = new element(-3, 0);
		element 	b = new element(-2, 1);
		c = new element(-1, 0);
		element d = new element(1, 0);		
		e = new element(2, 0.25);
		element h = new element(2.001, 0);
		elementsA = new ArrayList<element>(Arrays.asList(a,b,c,d,e,h));
		SetB = new set(elementsA, -4, 3, "SetB");

		System.out.println(SetA);
		System.out.println(SetB);
		set SetAuB = set.union(SetA, SetB, "zadeh");
		SetAuB = set.union(SetA, SetB, "proba");
		SetAuB = set.union(SetA, SetB, "lukas");

		set SetAnB = set.intersection(SetA, SetB, "zadeh");
		//System.out.println(SetAuB);
		System.out.println("....");
		//System.out.println(SetAnB);

    }
}
