import java.util.Arrays;
import java.util.ArrayList;

public class fuzzySetsAPI{
    public static void main(String[] args){
		element a = new element(2, 0);
		element b = new element(1, 1);
		element c = new element(0, 0);
		System.out.println("1. Initialisation des points");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println("***");

		System.out.println("2. Création d'un ensemble");
		ArrayList<element> elementsA = new ArrayList<element>(Arrays.asList(a,b,c));
		double min=0, max=10;
		set SetA = new set(elementsA, min, max, "SetA");
		System.out.println("Taille: "+ SetA.length());

		//System.out.println(SetA);
		//System.out.println("Nom: "+ SetA.name);
		System.out.println("***");

		System.out.println("3. Valeur aux points :");
		System.out.println("0   :"+SetA.valueAt(0));
		System.out.println("0.5 :"+SetA.valueAt(0.5));
		System.out.println("1   :"+SetA.valueAt(1));

		//data d = new data(); 
		/** Use case
		    data = new data
		    ensemble A;
		    ensemble B = A.complementaire()
		*/

    }
}
