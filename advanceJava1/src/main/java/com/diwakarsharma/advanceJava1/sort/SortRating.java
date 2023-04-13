package com.diwakarsharma.advanceJava1.sort;

import java.util.Comparator;
import com.diwakarsharma.advanceJava1.sort.*;
import com.diwakarsharma.advanceJava1.CSVData.data.*;

public class SortRating implements Comparator<Tshirt> {

	public int compare(Tshirt tshirt1, Tshirt tshirt2) {
		
		return (int)(tshirt2.getRating()-tshirt1.getRating());
	}
}

