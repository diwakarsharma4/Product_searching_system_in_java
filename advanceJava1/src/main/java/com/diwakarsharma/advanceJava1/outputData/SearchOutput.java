package com.diwakarsharma.advanceJava1.outputData;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.diwakarsharma.advanceJava1.CSVData.data.*;
import com.diwakarsharma.advanceJava1.inputData.*;
import com.diwakarsharma.advanceJava1.CSVData.collectCSV.*;
import com.diwakarsharma.advanceJava1.outputData.*;
import com.diwakarsharma.advanceJava1.sort.*;

public class SearchOutput {
	Scanner scn;
	
	public static ArrayList<Tshirt>getMatchingTshirts(SearchInput tshirtsSearchIp) throws FileNotFoundException{
		 
		ArrayList<Tshirt>tshirt = new ArrayList<Tshirt>();
		ArrayList<Tshirt>allTshirtData = AllData.getAllTshirts(); //all required data
		
		String inputFormat = String.format("%s,%s,%s", tshirtsSearchIp.getColor(),tshirtsSearchIp.getSize(),tshirtsSearchIp.getGender());
		
		String outputFormat;
		String output = tshirtsSearchIp.getOutputPreference().name();
		
		System.out.println("Your choice of Output Preference is : ");
		
		for(Tshirt allTshirtDataiterator : allTshirtData) {
			
			outputFormat = String.format("%s,%s,%s", allTshirtDataiterator.getColor(),allTshirtDataiterator.getSize(),allTshirtDataiterator.getGender());
			
			if(inputFormat.equalsIgnoreCase(outputFormat))
				tshirt.add(allTshirtDataiterator);
			
		}
		
		
		//sorting on the basis of output preference
		if(output.equalsIgnoreCase("Price")) {
			
			Collections.sort(tshirt,new SortPrice());
			System.out.println(output);
			
		}else if(output.equalsIgnoreCase("Rating")) {
			
			Collections.sort(tshirt,new SortRating());
			System.out.println(output);
			
		}else {
			
			Collections.sort(tshirt,new SortPrice());
			Collections.sort(tshirt, new SortRating());
			System.out.println(output);
			
		}
		
		System.out.println("\n\n");
		
		return tshirt;
	}

}
