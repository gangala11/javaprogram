package task;

import java.util.HashMap;

public class mapcontain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> h1=new HashMap<Integer,String>();
		h1.put(1, "java");
		h1.put(2, "python");
		h1.put(3, "iot");
		h1.put(4, "fs");
        boolean hasMapping=h1.containsKey(2) && h1.containsValue("iot");
        System.out.println("map has key-value mapping?"+hasMapping);


	}

}
