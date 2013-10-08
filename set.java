import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;


public class set{
	public String name = "default";
	public ArrayList<element> elements;
	public double min;
	public double max;
	public double step;
	
	//Constructeurs
	public set(ArrayList<element> elements, double min, double max, String name){
	    this.name = name;
	    //this.elements = new elements[elements.length+2]={new element(min,0), elements ,new element(max,0)};

	    this.elements = elements;
	    Collections.sort(elements);

	    // Premier et dernier élements
	    elements.get(1);
	    elements.get(this.length());

	    //this.min = elements[0].x;
	    //this.max = elements[elements.length-1].x;
	    this.step = 0.01; // to be refined...
	}

	//Informations
	public int length(){
	    return elements.size();
	};
	public String toString(){
		String out = name+"\n";
		out = out + this.length()+" points\n";
		for (element e : elements){
			out = out + elements.toString()+"\n";
		}
		return out;
	}
	public double valueAt(double x){
	    return valueAt(x, 0);
	}
	public double valueAt(double x, int startIndex){
		double x1,x2,y1,y2;
		int i = startIndex;
		do{
			x1 = elements.get(i).x ;
			x2 = elements.get(i+1).x;
			if(x2>=x){
				if(x1<=x){
					y1 = elements.get(i).y;
					y2 = elements.get(i+1).y;
	    			return (y2-y1)/(x2-x1) * (x-x1) + y1;
				} else{
					System.out.println("Error : x2<x1 ??");
				}
			}
			i = i + 1; // Essayer des sauts plus grands ? par dichotomie ? Ca dépend..
						// S'il y a des points tous les STEPS, ça prend plein de place mais on trouve vite ce qu'on veut...
		} while(x2>x);
	    return 0;
	}

	//Opérations ensemblistes
	public set union(set A, set B, String method){
	    return A;
	}
	public set intersection(set A, set B, String method){
	    return A;
	}
	public set complementaire(set A){
	    return A;
	}
	//public static set apply(ensemble A, math.function f){}{
	    // Premier algo possible
	    // calcul des valeurs des points (x,y) de A -> double[][] (f(x), y)
	    // Si on calcul un f(x) déjà obtenu, on prend la valeur d'appartenance la plus grande
	    // ici le pas de discretisation va changer...
	    // Deuxième algo possible
	    // On pose discrètise l'ensemble des valeurs des f(x)
	    // On calcule les f-1(x), on prend la plus grande valeur...
	//}
}