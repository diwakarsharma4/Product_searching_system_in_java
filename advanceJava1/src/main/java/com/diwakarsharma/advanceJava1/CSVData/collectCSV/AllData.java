package com.diwakarsharma.advanceJava1.CSVData.collectCSV;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.diwakarsharma.advanceJava1.CSVData.data.*;


//import week5.advancejava1.CSVFile.*;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class AllData {
	public static ArrayList<Tshirt>getAllTshirts(){ 
		File f = new File("C:\\Users\\Asus\\Desktop\\Product_searching_system_in_java\\Product_searching_system_in_java\\advanceJava1\\src\\main\\java\\com\\diwakarsharma\\advanceJava1\\CSVData\\CSVFiles");
		ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
		
		ArrayList<Tshirt>getalldata=new ArrayList<Tshirt>();
		
		for (File file : files) {
		    if (file.isFile()) {
		    	CSVReaderMethod(file.getPath(), getalldata); //adding all file details into arraylist
		    }
		}
		
		return getalldata;
		
	}
	
	private static void CSVReaderMethod(String filePath,ArrayList<Tshirt>getalldata) {
		try {
			CSVParser parser = new CSVParserBuilder().withSeparator('|').withIgnoreQuotations(true).build();
			CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath)).withCSVParser(parser).withSkipLines(1).build();
			
			String[] S;
			try {
				while((S=csvReader.readNext())!=null) {
					Tshirt tshirt = new Tshirt();
					
					tshirt.setId(S[0]);
					tshirt.setName(S[1]);
					tshirt.setColor(Color.valueOf(S[2].toUpperCase()));
					tshirt.setGender(Gender.valueOf(S[3].toUpperCase()));
					tshirt.setSize(Size.valueOf(S[4].toUpperCase()));
					tshirt.setPrice(Double.parseDouble(S[5]));
					tshirt.setRating(Double.parseDouble(S[6]));
					tshirt.setAvalibilty(S[7]);
					
					getalldata.add(tshirt);
					
				}
				
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
