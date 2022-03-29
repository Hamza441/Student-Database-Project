package test;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


import utility.Filter;


public class DataClient {

	public static String location = "/Users"
					+ File.separator  +  "hamseahmed"
					+ File.separator  +  "Documents"
					+ File.separator +"Students_Min.txt"
					;
	
	
        // public static String location="/U/hamseahmed/Downloads/Students_Min.txt";

		/*****************************************************
		 * method: main(String[]) runs program
		 ***************************************************/
		public static void main(String[] args) throws IOException {
			Filter filter = new Filter();
			filter.read("/Users/hamseahmed/Documents/Students_Min.txt");
			//filter.read("/Users/hamseahmed/Documents/Scores.txt");
			
			//System.out.println(filter.read(location));
			
			filter.filterOver25("filterOver25.txt");
			filter.sortGPAorder("SortinngAge.txt");
			filter.sortAge("Sorting Age.txt");
     		filter.filterunder25("FilteringUnder25.txt");
			
		      
		     
		

	}
}

