
public class Category {
	
	/*Name of Category*/
	String name;
	
	/*How often is the category used*/
	int counter;
	
	public Category(String n, int c){
		name = n;
		counter = c;
	}
	
	//Wenn gespielt vermerken
	public void played(){
		counter++;
	}
	
	public String toString(){
		return name+" ."+counter;
	}

}
