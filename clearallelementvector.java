package task;
import java.util.Vector;
public class clearallelementvector {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> v=new Vector<String>();
		v.add("ganga");
		v.add("jamuna");
		v.add("vijay");
		v.add("mithra");
		System.out.println("before clear:"+v);
			v.clear();//remove all elements
			System.out.println("after clear:"+v);
		}

	}
