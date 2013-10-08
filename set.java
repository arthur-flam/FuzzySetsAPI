import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

// mettre privé name, etc. set/get
public class set{
	public String name;
	public ArrayList<element> elements;
	public double min, max, step;
	public double vLeft = 0;
	public double vRight = 0; // values outside of bounds. Not always 0 :(

	//Constructors
	public set(set another){
    	this.name = another.name;
    	this.elements = another.elements;
    	this.min = another.min;
    	this.max = another.max;
    	this.step = another.step;
  	}
	public set(ArrayList<element> elements, double min, double max, String name){ // Doesn't support values != 0 outside of bounds
	    this.elements = elements;
	    Collections.sort(elements);
	    // Bounds
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
	    this.vLeft = vLeft;
	    this.vRight = vRight;
	    this.max = max;
	    this.step = 0.01; // min(plus petite précision,0.01) ?
	    this.name = name;
	}

	//General methods
	public int length(){
	    return elements.size();
	};
	public String toString(){
		String out = name+"\n";
		out = out + this.length()+" points\n";
		out = out + "inf:" + this.min + "  (" + this.vLeft + ")\n";
		out = out + "sup:" + this.min + "  (" + this.vRight + ")\n";
		for (element e : elements){
			out = out + e.toString()+"\n"; // elements.toString() suffit 
		}
		return out;
	}

	//Accessing values
	public double valueAt(double x){
		if(x > max) {return vRight;};
		if(x < min) {return vLeft;};
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
	public static set complementaire(set A){
		set Ac = new set(A);
		Ac.name = "c("+Ac.name+")";
		for(element e : Ac.elements){
			e.y = 1 - e.y;
		}
		Ac.vLeft = 1- Ac.vLeft;
		Ac.vRight = 1 - Ac.vRight;
	    return Ac;
	}
	public set union(set A, set B, String method){
		// bounds (min, max, vLeft, vRigth)
		// points : apply method... 
		// name, step...
	    //return AuB;
	    return A;
	}
	public set intersection(set A, set B, String method){
		// bounds (min, max, vLeft, vRigth)
		// points : apply method... 
		// name, step...
	    //return AnB;
	    return A;
	}
	public set discretize(set A, double step){
		// Pour les unions... A voir si c'est utile.
		// x1.......x2 : plein de pooints interméiaidaire
		set dA = new set(A);
		return A;
	}
	//public static set apply(set A, IMapping f){}{ // step, min, max ?
	//	set fA = new set(A);
		// Choose bounds
		// discretize
		// get values...
	    //return A;
	//}
}