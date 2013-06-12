package com.milo;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		if( args.length < 1){
			System.out.println("Please provide the input file");
			return;
		}
		
		//String filePath= "src\\com\\test\\inputFile.txt";
		String filePath = args[0];
		MiloProcessFile mfo = new MiloProcessFile();
		mfo.processFile(filePath);
		
		
	}

}
