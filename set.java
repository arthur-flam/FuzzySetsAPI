import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

// mettre privé name, etc. set/get
public class set{
	public String name;
	public ArrayList<element> elements;
	public double min, max, step=0.1;
	public double vLeft = 0;
	public double vRight = 0; // values outside of bounds. Not always 0 :(

	//Constructors
	public set(set another){ // pour faire une vrai copie !
    	this.name = another.name;
    	ArrayList<element> elementsCopy = new ArrayList<element>();
    	int i=0;
    	for(element e : another.elements){
    		elementsCopy.add(i, new element(e.x, e.y));
    		i=i+1;
    	}
    	this.elements = elementsCopy;
    	this.min = another.min;
    	this.max = another.max;
    	this.step = another.step;
  	}
	public set(ArrayList<element> elements, double min, double max, String name){ // Doesn't support values != 0 outside of bounds
	    this.elements = elements;
	    Collections.sort(elements);
	    // Bounds
	    element first = elements.get(0);
	    element last  = elements.get(this.length()-1);
	    if(first.x > min){
	    	elements.add(0, new element(min, vLeft));
	    } else if(first.x < min){
		    	System.out.println("La borne inférieure est supérieure à un des élements");
	    }
	    if(last.x < max){
	    	elements.add(new element(max, vRight));
	    } else if(last.x > max){
		    	System.out.println("La borne supérieure est inférieure à un des élements");
	    }
	    this.min = min;
	    this.vLeft = vLeft;
	    this.vRight = vRight;
	    this.max = max;
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
		out = out + "sup:" + this.max + "  (" + this.vRight + ")\n";
		for (element e : elements){
			out = out + e.toString()+"\n"; // elements.toString() suffit 
		}
		return out;
	}

	public double valueAt(double x){
		if(x > max) {return vRight;};
		if(x < min) {return vLeft;};
	    return valueAt(x, 0);
	}
	public double valueAt(double x, int startIndex){
		double x1,x2,y1,y2;
		if(x<min){
			return vLeft;
		} else if(x>max){
			return vRight;
		}
		int i = Math.max(0,startIndex);
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
	public ArrayList<Double> valueAt(ArrayList<Double> xx){
		ArrayList<Double> values = new ArrayList<Double>(); 
		for(double x : xx){
			values.add(valueAt(x));
		}
		return values;
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
	private set applyConorm(set A, set B, conorm n){ // returns elements in common for A and B
		ArrayList<element> elements = new ArrayList<element>();	
		element a; //current element
		element b;
		element e;
		int i=0;
		int j=0;
		boolean Adone = FALSE; 
		boolean Bdone = FALSE; 
		while(!Adone && !Bdone){
			a = A.elements.get(i);
			b = B.elements.get(j);
			if(Adone){
				e.x = b.x
				e.y = norm.compute(A.valueAt(e.x, i-1),B.valueAt(e.x, j))
				B.add(e)
				j = j + 1;
			} else if(Bdone){
				e.x = a.x
				e.y = norm.compute(A.valueAt(e.x, i),B.valueAt(e.x, j-1))
				elements.add(e);
				i = i + 1;
			} else{
				if(a > b){
					e.x = a.x
					e.y = norm.compute(A.valueAt(e.x, i-1),B.valueAt(e.x, j))
					elements.add(e);
					j = j + 1;
				} else if (a < b) {
					e.x = a.x
					e.y = norm.compute(A.valueAt(e.x, i),B.valueAt(e.x, j-1))
					elements.add(e);
					i = i + 1;			 
				} else {
					e.x = a.x
					e.y = norm.compute(A.valueAt(e.x, i),B.valueAt(e.x, j))
					i = i + 1;
					j = j + 1;
					elements.add(e);
				}
			}
			Adone = i<A.length(); //iteration complete
			Bdone = j<B.length();
		}
		return elements;
	}
	public set union(set A, set B, String method){
		name = '(' + A.toString() + ') U (' + B.toString() + ')';
		min = Math.min(A.min, B.min);
		max = Math.max(A.max, B.max);
		step = Math.min(A.step, B.step);
		if(method="proba"){
			A = Set.discretize(A, A.step);
			B = Set.discretize(B, B.step);
		}
		tnorm n;
		switch(method){
			case "proba": n = new tconorm_proba(); break;
			case "zadeh": n = new tconorm_zadeh(); break;
			case "lukas": n = new tconorm_else(); break;
		} else {System.out.println("Please provide a norm in: proba/zadeh/lukas");}
		ArrayList<element> elements = applyNorm(A, B, n);
		set AuB = new set(elements, min, max, name);
		AuB.vLeft = n.compute(A.vLeft,B.vLeft);
		AuB.vRigth = n.compute(A.vRigth,B.vRigth);
	    return AuB;
	}
	public set intersection(set A, set B, String method){
		name = '(' + A.toString() + ') n (' + B.toString() + ')';
		min = Math.min(A.min, B.min);
		max = Math.max(A.max, B.max);
		step = Math.min(A.step, B.step);
		if(method="proba"){
			A = Set.discretize(A, A.step);
			B = Set.discretize(B, B.step);
		}
		tnorm n;
		switch(method){
			case "proba": n = new tnorm_proba(); break;
			case "zadeh": n = new tnorm_zadeh(); break;
			case "lukas": n = new tnorm_else(); break;
		} else {System.out.println("Please provide a norm in: proba/zadeh/lukas");}
		ArrayList<element> elements = applyNorm(A, B, n);
		set AnB = new set(elements, min, max, name);
		AuB.vLeft = n.compute(A.vLeft,B.vLeft);
		AuB.vRigth = n.compute(A.vRigth,B.vRigth);
	    return AnB;
	}
	public static set discretize(set A, double step){ // utile pour appliquer des fonctions 
		element e;
		set dA = new set(A);
		dA.elements.clear();
		for(double i=A.min; i<=A.max; i=i+step){
				e = new element(i, A.valueAt(i));
				dA.elements.add(e);	
		}
		return dA;
	}
	public static set apply(set A, IMapping f, double step){ // step, min, max ?
		double v;
		element el;
		double fmin = f.compute(A.elements.get(0).x);
		double fmax = f.compute(A.elements.get(0).x);
		for(element e : set.discretize(A,step).elements){
			v = f.compute(e.x);
			if(e.y>0){
				if(v>fmax){fmax = v;};
				if(v<fmin){fmin = v;};				
			}
		}
		ArrayList<element> elements = new ArrayList<element>();
		ArrayList<Double> antecedents;
		ArrayList<Double> values;
		double padding = (fmax-fmin)*0.1;
		fmax = fmax + padding;
		fmin = fmin - padding;
		for(double i=fmin; i<=fmax; i=i+step){
			antecedents = f.reverse(i);
			if(!antecedents.isEmpty()){
				values = A.valueAt(antecedents); // faire une dichotomie..
				v = Collections.max(values);
				el = new element(i, v);
				elements.add(el);
			}
		};
		String newName = f.toString()+"("+A.name+")";
		set fA = new set(elements, fmin, fmax, newName);
	    return fA;
	}
}