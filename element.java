public class element implements Comparable{
	double x;
	double y;

	public element(double x, double y){
	    this.x = x;
	    this.y = y;
	}

	public String toString(){
	    return "x:" + x + " y:" + y;
	}

	public int compareTo(Object o){
		element e = (element) o;
		return (int) (this.x - e.x);	
	}

	// public elements[] sort(element[] elements){
	// 	int length = elements.length;
	// 	if(length ==1){
	// 		return elements;
	// 	} else{
	// 		double pivot = elements[length/2].x; //pivot au milieu parce que ce sera souvent déjà trié...
	// 		element[] l;
	// 		element[] r;
	// 		for(int i = 0; i < elements.length; i++){
	// 			current = elements[i];
	// 			if(current.x < pivot){
	// 				l = l + x // on fait pas mal de copies, mais bon, on s'en fout un peu.
	// 			} else{
	// 				r = r + x
	// 			}
	// 		}
	// 		return elements[] l+r;
	// 	}
	// }
}
