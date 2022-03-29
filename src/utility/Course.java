package utility;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



public class Course {
	
	// encapsulated data fields.
	private Title course;
	private double gpa;
	private List<Double> scores;
	
	// CONSTRUCTORS:
	
	public Course() {
		this.course = Title.CSC;
		this.scores = null;
	}
	
	public Course(Course other) {
		this.course = other.course;
		this.gpa = other.gpa;
		this.scores = other.scores;
		 
	}
	
	
	public Course(Title course, List<Double> scores) {
		this.course = course;
		this.scores = scores;			
}

		// METHODS
	
	public int compareGpa(Course Other) {
		if (this.getGpa()== Other.getGpa()) {
			return 0;
		}
		else {
			return (int) (this.getGpa()- Other.getGpa());
		}
		
	}
	
	public final int compareTo(Course other) {
		
		if (this.getTitle().equals(other.getTitle())) {
			return 0;
		}
		else {
			return this.getTitle().compareTo(other.getTitle());
		}
		
	}
	
	public double computeGPA() {
		int average = 0;
		int sum =0;
		for (Double item : scores) {
			sum += item;
		} 
		average = sum/scores.size();
		
		return gpa = (average -35)/15;
	}
	
	public Title getTitle( ) {
		return course;	
	}
	
	public List<Double> getScore1() {
		return scores;
	}
	
	public boolean equals (Object other) {
	
		if (!(other instanceof Course)) {
			return false;
			
		}
		Course cObj= (Course) other;
		
		return this.getTitle().equals(cObj.getTitle())
				&& this.getGpa()==cObj.getGpa()
				&& this.eqaulScores(cObj); 	
	}

	public boolean eqaulScores(Course other) {
		List<Double> s = other.getScore1();
		if (this.scores.size()!= other.scores.size()) return false;
		for (int i = 0; i < this.scores.size(); i++) {
			if (this.scores.get(i)!=s.get(i)) return false;
			
		}
		return true;	
	}
	
	// Calling compute gpa method and use it
	public double getGpa() {
		this.gpa = computeGPA();
		return gpa;	
	}
	
	
	public void setTitle(Title course) {
		this.course = course;	
	}
	
	public String toFile() {
		return (scores.get(0)+ "," + scores.get(1) + "," + scores.get(2) + ",");	
	}
	
	


	public String toString() {
		return course.toString( )  +  " "  +  computeGPA();
				
				
					
	}
	
	
}

