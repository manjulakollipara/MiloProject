package com.milo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MiloProcessFile {

	ArrayList<Double> ssValueList = new ArrayList<Double>();
	ArrayList<Double> finalList = new ArrayList<Double>();
	public static ArrayList<String> combos;
	int n, r;
	Double[][] prodCustArray = null;
	Map<String, Boolean> prodSelected = new HashMap<String, Boolean>();
	Map<String, Boolean> custSelected = new HashMap<String, Boolean>();
	String[] products = null;
	String[] customers = null;
	Double ssValue = 0.00d; 
	boolean nisP;

	/* For windows file, format the Path
	 * filePath filePath
	 * returns String
	 */
	public static String formatFilePath(String filePath){
		filePath.replace("\\", "\\\\");
		return filePath;

	}

	/* This method will compute the ss values for each test case
	 * filePath input file path
	 */
	public void processFile(String filePath){

		try{
			filePath = MiloProcessFile.formatFilePath(filePath);
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			prodSelected.clear();
			custSelected.clear();

			// Read each Line from the file
			String currentLine = null;
			while( (currentLine = br.readLine()) != null ) {

				System.out.println("current Line being processed = "+ currentLine);
				// Fetch productsList
				String[] token = currentLine.split(";");
				String productsList = token[1];

				if( productsList.length() > 0){

					products = token[1].split(",");
					customers = token[0].split(",");
					
					if (products.length > customers.length)	{
						n = products.length; r = customers.length; nisP = true;
					}
					else{
						r = products.length; n = customers.length; nisP = false;
					}
					
					System.out.println("n="+ n + " and r="+r);
					prodCustArray = new Double[products.length][customers.length]; 
					
					for( int i = 0; i< products.length; i++){

						System.out.println("product = "+ products[i]);
						if( MiloUtility.getString(products[i]).length() % 2 == 0 ){
							processEvenProducts(products[i], i);
						}else { 
							processOddProducts(products[i], i);	
						}

					}
				}

				computeMax();
				displayMax();
			
			}

		}catch( Exception e){
			e.printStackTrace();
		}
	}

	/* Method to determine the GCD between two values
	 * ssValue calculated previosu suitability score
	 * value1 length of customer name
	 * value2 length of product name
	 */
	public Double updateProdCustPair(Double ssValue, String customer, String product){
		
		int gcd = MiloUtility.getCommonFactors(MiloUtility.getString(customer).length(), MiloUtility.getString(product).length()); 

		if( gcd > 1){
			System.out.println("gcd("+customer.length()+","+product.length()+") = SSValue = "+ ssValue + " * 1.50d" );
			ssValue *= 1.50d;
		}

		return ssValue;
	}

	public void processEvenProducts(String product, int i){
		
		for(int j = 0; j < customers.length; j++){
			System.out.println("customer Name: "+ customers[j]);
			// Get vowels count from customer
			int vCount = MiloUtility.getVowelsCount(customers[j]);
			System.out.println("vowels Count = "+ vCount);
			ssValue = (double) (vCount * 1.50d);
			prodCustArray[i][j] = updateProdCustPair(ssValue, customers[j], product);
			//prodCustArray[i][j] = ssValue;
		}

	}
	
	public void processOddProducts(String product, int i){
		
		for(int j=0; j<customers.length; j++){

			System.out.println("customer Name: "+ customers[j]);
			// Get consonants count from customer
			ssValue = MiloUtility.getConsonantsCount( MiloUtility.getString(customers[j])) * 1.00d;
			prodCustArray[i][j]= updateProdCustPair(ssValue, customers[j], product);
		}

	}
	
	public void computeMax(){

		ArrayList<String> combos = new ArrayList<String>();
		try{
			for( int i=0; i< products.length; i++)
				for(int j=0; j< customers.length; j++){
					System.out.println("preCalculated value = "+ prodCustArray[i][j]);
				}

			MiloUtility.permutation(n, r, combos);
			// For each combination of Product+Customer get the SS Value
			for( String s: combos){
				System.out.println("pair: "+ s);
			}

			Double finalSSValue = 0.00d;
			for( int i=0; i< combos.size(); i++){
				
				String s = combos.get(i); //012
				//char[] s= combos.get(i).toCharArray();
				for(int j=0; j< s.length(); j++){
					finalSSValue += prodCustArray[j][s.charAt(j)-'0'];
				}
				
				ssValueList.add(finalSSValue);
				finalSSValue = 0.00d;
			}

			Collections.sort(ssValueList);
			Comparator<Double> comparator = Collections.reverseOrder();
			Collections.sort(ssValueList,comparator);
			
			finalList.add(ssValueList.get(0));
			ssValueList.clear();
			
		}catch(Exception e){
			e.printStackTrace();
		}


	}
	
	
	void displayMax(){

		// Get max value from the list
		Iterator<Double> it = finalList.iterator();
		while(it.hasNext()){
			System.out.println((Double) it.next() );//+ " Pair = "+ combos.get(maxComboPair));

		}

	}



}
