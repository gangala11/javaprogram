package set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class settype {
	// main driver method

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creating an object of set class
		//Declaring object of integer type
		Set<Integer> a=new HashSet<Integer>();
		//Adding all element to list
		a.addAll(Arrays.asList(
				new Integer[] {1,3,7,8,4,0,7,9}));
		Set<Integer> b=new HashSet<Integer>();
		b.addAll(Arrays.asList(
				new Integer[] {1,3,7,5,4,0,7,5}));
		//to find union
		Set<Integer> u=new HashSet<Integer>(a);
		u.retainAll(b);
		System.out.print("union of the two set");
		System.out.println(u);
		//to find intersection
		Set<Integer> i=new HashSet<Integer>(a);
		u.addAll(b);
		System.out.print("intersection of the two set");
		System.out.println(i);
		//to find difference
		Set<Integer> d=new HashSet<Integer>(a);
		u.removeAll(b);
		System.out.print("difference of the two set");
		System.out.println(d);
		

	}

}
