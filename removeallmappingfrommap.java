package task;

import java.util.HashMap;

public class removeallmappingfrommap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> h1=new HashMap<Integer,String>();
		h1.put(1, "java");
		h1.put(2, "python");
		h1.put(3, "iot");
		h1.put(4, "fs");
		System.out.println("before clear:"+h1);
		h1.clear();
		System.out.println("after clear:"+h1);


	}

}
