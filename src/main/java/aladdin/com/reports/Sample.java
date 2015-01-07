package aladdin.com.reports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("java.io.tmpdir"));
		List<HashMap<String,String>> al = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> products = new HashMap<String,String>();
		products.put("a", "a1");
		products.put("b","b1");
		al.add(products);
		
		
		
	}

}
