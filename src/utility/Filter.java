package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;






public class Filter {
	
	// encapsulated data fields
	
	private ArrayList<Student> list ;
	
	
	
	
	// Constructor
	
	public Filter() {
		this.list = new ArrayList<Student>();
		
		
	}	
	
	
	
	// Methods
	
	
	// filters the data for students over 25 and writes it to the indicated file location
	public void filterOver25(String location ) throws FileNotFoundException {
		File file = new File(location);
		PrintWriter output = new PrintWriter(file);
		
//		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).age() > 25) {
				output.println(list.get(i));
				
			}
			
		}
		output.close();
		
	}	
	
	

	// filters the data for students under 25 and writers it to the indicate file location
	public void filterunder25(String location ) throws FileNotFoundException {
		File file = new File(location);
		PrintWriter output = new PrintWriter(file);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).age() < 25) {
				output.println(list.get(i));
				
			}
			
		}
		output.close();
		
		
	}
	
	// This method takes the course information as a string and return the COURSE object.
	public static Course makeCourse(String str) {
		String[] info = str.split("=");
		Title prefix =Title.valueOf(info[0]);
		List<Double> scores = makeScores(info[1]);
		return new Course(prefix, scores);
	}
	
	public static List<Double> makeScores(String str) { 
		String[] info = str.split(":");
		List<Double> scores  = new ArrayList<Double>();
		for (int i = 0; i < info.length; i++) {
			scores.add(Double.parseDouble(info[i]));
		}
		
		return scores;
	
	}
	
	// parse the input string to a student object.
		public static Student parse (String line) throws IllegalArgumentException {
			String[] info =line.split(", ");
			String name = info[0];
			double gpa = 0;
			int age = Integer.parseInt(info[1]);
			Rank rank = Rank.valueOf(info[2]);
			
			List<Course> courses  = new ArrayList<Course>();
			for (int i = 3; i < info.length; i++) {
				courses.add(makeCourse(info[i]));
				
			}
			
			
			
			return new Student(name, age, rank, courses);
		}
	
		
		// Reading the file and add the information to the student list
		public void read(String location) throws FileNotFoundException{
			
			
			File    file1 = new File(location);
			Scanner input = new Scanner(file1);
		
			Student student = null; 
		
			while(input.hasNextLine()) {
				student = parse(input.nextLine());
			    list.add(student);				
			}
			
			input.close();
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
				
			}
			
			}
		
		
		
		
		
		public static void write(String location) throws IOException{
			
			// set path name : YOU MUST CHANGE FOR YOUR COMPUTER
			
			//create a file object
			File file = new File(location);	
			
			//check if file exists
			if (file.exists()) {
				System.out.println("File exists");
			}
			
			//create a file at the location indicated
			PrintWriter output = new PrintWriter(file);
			
			//write formatted output to file
			
			
			//close the file
			output.close();

		
		
		}
		
		
		public void sortAge(String location) throws FileNotFoundException {
			
			Student temp = null;
			for (int i = 0; i < list.size(); i++) {
				for (int j = 1; j < list.size(); j++) {			
					if (list.get(j).compareTo(list.get(j-1)) < 0) {
						temp = list.get(j);
						list.set(j, list.get(j - 1));
						list.set(j - 1, temp);
						
					}
				}			
	}
				
							
	}
		
		
		
		public void sortAlphabeticalOrder(String location) throws FileNotFoundException {
			
			File file = new File(location);
			
			PrintStream output = new PrintStream(file);
			Student first = null;
			Student second = null;
			
			for (int i = 0; i < list.size(); i++) {
				for (int j = 1; j < list.size(); j++) {
					
					second = list.get(j);
					first = list.get(j-1);
					if (second.compareTo(first)<0) {
						list.set(j, first);
						list.set(j - 1 , second);
					}
					
					
				}
				
			}
			
			
		}
		
		
		public void sortGPAorder(String location) throws FileNotFoundException {
			Student temp = null;
			for (int i = 0; i < list.size(); i++) {
				for (int j = 1; j < list.size(); j++) {			
					if (list.get(j).compareTo(list.get(j-1)) < 0) {
						temp = list.get(j);
						list.set(j, list.get(j - 1));
						list.set(j - 1, temp);
						
					}
				}		
			
			}
			
		}
		
		
		
		
		public void wirte(String location) throws FileNotFoundException {
			File file = new File(location);
			PrintStream writer = new PrintStream(file);

			if (file.exists()) {
				for (int i = 0; i < list.size(); i++) {
					writer.println(list.get(i) + "\n"); 
				}

			}
			writer.close();

		}
			
			
			
			
		
		
		public void writeCS(String location) throws FileNotFoundException {
			File file = new File(location);
			PrintStream writer = new PrintStream(file);

			if (file.exists()) {
				for (int i = 0; i < list.size(); i++) {
					writer.println(list.get(i).toFile() + "\n"); 
				}

			}
			writer.close();
			
			
		}
		
		
		
	}



	


	
	



