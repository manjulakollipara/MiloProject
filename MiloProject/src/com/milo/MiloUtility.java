package com.milo;

import java.util.ArrayList;

//import com.unused.ProdCust;

public class MiloUtility {

	public static int getVowelsCount(String customer){
		int vCount = 0;
		
		customer = customer.toLowerCase();
		for (int i=0; i< customer.length(); i++){
			char c = customer.charAt(i);
			if( c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='y') {
				vCount++;
			}
		}
		return vCount;
	}

	public static Double getConsonantsCount(String customer){
		int cCount = 0;
		
		customer = customer.toLowerCase();
		System.out.println("lenght ="+ customer.length());
		for (int i=0; i< customer.length(); i++){
			char c = customer.charAt(i);

			if (c >= 'a' && c <= 'z')
			{
				if (c !='a' && c !='e' && c !='i' && c !='o' && c!='u' && c != 'y') {
					cCount++;
					//System.out.println("cCount = "+ cCount);
				}
			}
		}
		return cCount * 1.0;
	}

	public static int getCommonFactors(int value1, int value2) {
		// TODO Auto-generated method stub
		
		// Used Euclid's algorithm
		// http://java67.blogspot.com/2012/08/java-program-to-find-gcd-of-two-numbers.html
		
		if( value2 == 0) {
			return value1;
		}
		
		return getCommonFactors(value2, value1 % value2);
	}
	
	
	public static Double getMax( Double x, Double y){
		return (x > y) ? x: y;
	}
	
	
	public static String getString(String str){
		
		String newStr = new String();
		try{
			// 
			newStr = str.replaceAll("[^A-Za-z]", "").replaceAll("\\s+", "");
		}catch(Exception e){
			e.printStackTrace();
		}
		return newStr;
	}

	public static void permute(int level, String permuted,boolean used[], int n, int r, ArrayList<String> combos) {
		if (level == r) {
			if (!combos.contains(permuted))
				combos.add(permuted);
		} else {
			for (int i = 0; i < n; i++) {
				if (!used[i]) {
					used[i] = true;
					permute(level + 1, permuted + i,
							used, n, r, combos );
					used[i] = false;
				}
			}
		}
	}

	public static void permutation(int n, int r, ArrayList<String> combos){
		//combos = new ArrayList<>();
		boolean used[] = new boolean[n];
		permute(0, "", used, n, r, combos);
		System.out.println(combos.size());
		System.out.println(combos.toString());
	}
	

	
	
}
