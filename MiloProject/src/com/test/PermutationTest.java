package com.test;

import java.util.ArrayList;

public class PermutationTest {

	public static ArrayList<String> combos;
	
	public static void permute(int level, String permuted,
			boolean used[], int n, int r) {
		//int length = n;
		if (level == r) {
			if (!combos.contains(permuted))
				combos.add(permuted);
		} else {
			for (int i = 0; i < n; i++) {
				if (!used[i]) {
					used[i] = true;
					permute(level + 1, permuted + i,
							used, n, r );
					used[i] = false;
				}
			}
		}
	}
	
	public static void permutation(int n, int r){
		//String s = "hel";
		combos = new ArrayList<>();
		boolean used[] = new boolean[n];
		permute(0, "", used, n, r);
		System.out.println(combos.size());
		System.out.println(combos.toString());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			permutation(3,2);
		}catch(Exception e){
			System.out.println("Permutation errored out");
			e.printStackTrace();
		}

		
	}
	
	

	
	

}
