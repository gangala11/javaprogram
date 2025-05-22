package set;
import java.util.Vector;
public class vector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Integer> v1=new Vector<Integer>();
		v1.add(12);
		v1.add(23);
		v1.add(25);
		v1.add(30);
		// iterating over vector elements
		// using  for loop
		for(int i=0;i<v1.size();i++)
		{
			// printing the element one by one
			System.out.print(v1.get(i)+" ");
			System.out.println(" the vector implementation"+v1);
			//using set() method to replace 12 with 21
			System.out.println("object is replaced"+v1.set(0, 21));
			//using set() method to replace 25 with 40
			System.out.println("object is replaced"+v1.set(2, 40));
			System.out.println("after set"+v1);
			v1.remove(3);
			System.out.println("after remove"+v1);
		}

	}

}
