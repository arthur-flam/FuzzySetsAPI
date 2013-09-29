public static void main(){
	System.out.println("Hello world.")
}


public static class ensemble{
	String name;
	point[] points;

	//Constructeurs

	//Informations
	public length()
	public String toString(){
		String out;
		for(int i = 0; i < point.length();i++){
			out += point.toString(point[i]);
		}
		return out;
	}
	public double valueAt(double x){
		//Trouver x1 < x < x2
		// par dichotomie ? A voir en cas d'appels multiples
		return (y2-y1)/(x2-x1) * (x1-x);
	}

	//Opérations ensemblistes
	public static ensemble union(ensemble A, ensemble B, String method){}
	public static ensemble intersection(ensemble A, ensemble B, String method){}
	public static ensemble complementaire(){}
	public static ensemble apply(ensemble A, math.function f){}{
		// Premier algo possible
			// calcul des valeurs des points (x,y) de A -> double[][] (f(x), y)
			// Si on calcul un f(x) déjà obtenu, on prend la valeur d'appartenance la plus grande
			// ici le pas de discretisation va changer...
		// Deuxième algo possible
			// On pose discrètise l'ensemble des valeurs des f(x)
			// On calcule les f-1(x), on prend la plus grande valeur...
	}
}

public static class data{
	public ensemble[] ef;
	public list();
	public add();
	public remove();
}

public static class point{
	double x;
	double y;
	public String toString(){
		return "x:" + x + "y:" + y+"\n";
	}
}


// Use case
data = new data
ensemble A;
ensemble B = A.complementaire()

