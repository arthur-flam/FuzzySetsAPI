import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;


public class set{
	public String name = "default";
	public ArrayList<element> elements;
	public double min;
	public double max;
	public double step;
	
	public set(ArrayList<element> elements, double min, double max, String name){
	    this.elements = elements;
	    Collections.sort(elements);

	    // Bornes
	    element first = elements.get(1);
	    element last  = elements.get(this.length()-1);
	    if(first.x > min){
	    	elements.add(0, new element(min, 0));
	    } else if(first.x < min){
		    	System.out.println("La borne inférieure est supérieure à un des élements");
	    }
	    if(last.x < max){
	    	elements.add(new element(max, 0));
	    } else if(last.x > max){
		    	System.out.println("La borne supérieure est inférieure à un des élements");
	    }
	    this.min = min;
	    this.max = max;
	    this.step = 0.01; // to be refined
	    this.name = name;
	}

	public int length(){
	    return elements.size();
	};
	public String toString(){
		String out = name+"\n";
		out = out + this.length()+" points\n";
		out = out + "Bounds : min:" + this.min + "  max:" + this.max + "\n";
		for (element e : elements){
			out = out + e.toString()+"\n"; // elements.toString() suffit 
		}
		return out;
	}
	public double valueAt(double x){
		if(x > max || x < min) {return 0;};
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
		} while(x>x2);
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