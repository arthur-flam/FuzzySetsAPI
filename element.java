public class element implements Comparable<element>{
	double x;
	double y;

	public element(double x, double y){
	    this.x = x;
	    this.y = y;
	}

	public String toString(){
	    return "x:" + x + " y:" + y;
	}

	public int compareTo(element e){
		return this.x>e.x ?1:0;	
	}

}
