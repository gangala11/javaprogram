package task;

import java.util.HashSet;

public class converthashsettoarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> h1=new HashSet<Integer>();
		h1.add(23);
		h1.add(25);
		h1.add(12);
		h1.add(14);
		Integer[] array=new Integer[h1.size()];
		h1.toArray(array);//convert to array
		System.out.println("Array elements:");
		for(Integer num:array)
		{
			System.out.println(num);
		}

	}

}
