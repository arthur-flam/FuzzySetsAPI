import java.util.Arrays;


public class set{
	public String name = "default";
	public element[] elements;
	public double min;
	public double max;
	public double step;
	
	//Constructeurs
	public set(element[] elements, String name){
	    this.name = name;
	    this.elements = elements;
	    Arrays.sort(elements);
	    this.min = elements[0].x;
	    this.max = elements[elements.length-1].x;
	    this.step = 0.01; // to be refined...
	}

	//Informations
	public int length(){
	    return elements.length;
	};
	public String toString(){
		String out = name+"\n";
		out = out + this.length()+" points\n";
		for(int i = 0; i < elements.length; i++){
		    out = out + elements[i].toString()+"\n";
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
			x1 = elements[i].x ;
			x2 = elements[i+1].x;
			if(x2>=x){
				if(x1<=x){
					y1 = elements[i].y;
					y2 = elements[i+1].y;
	    			return (y2-y1)/(x2-x1) * (x-x1) + y1;
				} else{
					System.out.println("Error : x2<x1 ??");
				}
			}
			i = i + 1; // Essayer des sauts plus grands ? par dichotomie ? Ca dépend..
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