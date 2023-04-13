package com.diwakarsharma.advanceJava1.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import com.diwakarsharma.advanceJava1.inputData.Input;
import com.diwakarsharma.advanceJava1.inputData.SearchInput;
import com.diwakarsharma.advanceJava1.outputData.Output;
import com.diwakarsharma.advanceJava1.outputData.SearchOutput;
import com.diwakarsharma.advanceJava1.CSVData.data.Tshirt;

//refresh component
import com.diwakarsharma.advanceJava1.thread.Refresh;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		// TODO Auto-generated method stub
        Input input = new Input();
        SearchInput searchIp = input.getInput();
        SearchOutput searchOp = new SearchOutput();
        
        //normal flow of program
        ArrayList<Tshirt>matchedTShirts = SearchOutput.getMatchingTshirts(searchIp);
        Output output = new Output();
        output.displayOutput(matchedTShirts);
        
        // sending input data to refresh component to get updated output
        Refresh refresh = new Refresh();
        refresh.refreshOutput(searchIp);
	}

}
