package set;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class linkedhashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> mp=new LinkedHashMap<Integer,String>();
		mp.put(1, "english");
		mp.put(2, "maths");
		mp.put(3, "science");
		for(Map.Entry<Integer,String> me:
			mp.entrySet())
		{
			System.out.print(me.getKey()+":");
			System.out.print(me.getValue());
		}

	}

}
