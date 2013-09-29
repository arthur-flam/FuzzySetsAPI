class fuzzySetsAPI{

    public static void main(String[] args){
	System.out.println("Hello world.");
	data d = new data();
    }
    
    
    public static class set{
	public String name;
	public element[] elements;
	
	//Constructeurs
	// TODO 

	//Informations
	public int length(){
	    return elements.length;
	};
	public String toString(){
		String out = "";
		for(int i = 0; i < elements.length; i++){
		    out = out + elements[i].toString();
		}
		return out;
	}
	public double valueAt(double x){
	    //Trouver x1 < x < x2
	    // par dichotomie ? A voir en cas d'appels multiples
	    //return (y2-y1)/(x2-x1) * (x1-x);
	    return 0;
	}

	//Opérations ensemblistes
	public static set union(set A, set B, String method){
	    return A;
	}
	public static set intersection(set A, set B, String method){
	    return A;
	}
	public static set complementaire(set A){
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

    public static class data{
	public set[] sets;
	public String[] list(){
	    String[] names;
	    names = new String[sets.length];
	    for(int i = 0; i>sets.length; i++){
		names[i] = sets[i].name;
	    }
	    return names;
	}
	public void add(){};
	public void remove(){};
    }

    public static class element{
	double x;
	double y;
	public String toString(){
	    return "x:" + x + "y:" + y+"\n";
	}
    }
    

/** Use case
data = new data
ensemble A;
ensemble B = A.complementaire()
*/


}
