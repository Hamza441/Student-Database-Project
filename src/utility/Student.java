package utility;

import java.util.List;





public class Student {
	
	// encapsulated data fields.
	private String name;
	private int age;
	private double gpa;
	private Rank rank;
	private List<Course> courses;
	
	//CONSTRUCTORS
	public Student(String name, int age,Rank rank, List<Course> courses) {
			this.name	= name;
			this.age 	=  age;
			
			this.rank	= rank;
			this.courses = courses;
	}
		
		
	public Student(Student other) {
			 this.age = other.age;
			 this.name = other.name;
			 this.gpa = other.gpa;
			 this.rank = other.rank;
			 this.courses = other.courses;
			
	}
	
				

	
	public double gpa() {
		return gpa;
	}


	public void gpa(double gpa) {
		this.gpa = gpa;
	}


	
	public int age() {
		return age;
	}

	
	public int compareGpa(Student other) {
		if (this.gpa() == other.gpa()) {
			return -1;
		}
		else if( gpa> other.gpa) {
			return 1;
		}
		 return 0;
		
	}
	
	public int compareTo(Student other) {
		if(lastName().compareTo(other.lastName()) != 0) {
			return lastName().compareTo(other.lastName());
		}else if(firstName().compareTo(other.firstName())!=0) {
			return firstName().compareTo(other.firstName());	
		}
		else if (gpa < other.gpa) {
			return -1;
		}
		else if (gpa> other.gpa) {
			return 1;
		}
			
		else if(age < other.age) {
			return  -1;
		}
		else if (age > other.age){
			return 1;
		}
		else {
			return 0;
		}
	}
		
			
 
		
	
	
	
	public double computeGPA() {
		
		int average = 0;
		int sum =0;
		for (Course item :courses) {
			sum += item.getGpa();
		} 
		average = sum/courses.size();
	
		return average;
	
}
		
	
	
	
	public List<Course> courseList() {
		
		return this.courses ;
	}
	

	public String courses() { 
		 String s1=new String();
		 for (int i = 0; i < courses.size(); i++) {
			s1+= courses.get(i).toString()+ "\n";
			
		}
		 return s1;
	 }
	
	
	public boolean eqaulCourses(Student other) {
		if(other instanceof Student) {
			return name.equals(other.name) &&
			age == other.age &&
			courses.equals(other.courses);
	}

		return false;
	}
		
	public boolean equals(Object object) {

		if(object instanceof Student) {
			Student other = (Student) object;
			return name.equals(other.name) &&
			age == other.age &&
			gpa == other.gpa &&
			rank == other.rank &&
			courses.equals(other.courses);
	}

		return false;
	}

	
	public boolean isOnDeansList() {
		if(this.gpa()>=3.7)
			return true;
		
		return false;
		
	}
	
	public boolean isOnProbation() {
		if(this.gpa()< 2.0)
			return true;
		
		
		return false;
		
	}
	
	
	public String lastName() {
		String[] info = name.split(" ");
		
		return info[1];
	}
	
	 
	 
	public String firstName() {
		String[] info = name.split(" ");
		
		return info[0];
	}
	
	
	public Rank getRank() {
		return rank;
	}
	
	public String getName() {
		return name;
	}

	
	
	public String toFile( ) {
		return firstName()+ "\t" + lastName() + "\t" + courses;
	}
	

	public String toString() {
		String result = "";
		
		
		
		return 
				"Name: \t" + 	"\t"  +	 name	 +	 "\n"
				+ "Age: \t"  + 	"\t" +	 age 	+ 	"\n"
				+ "Rank \t" +    		 rank 	+ 	"\n"
				+ "------------------------------"  + "\n" +
				
				courses()
				
				+ "-------------------------------" + 		"\n" +
				"Cum.GPA: \t" 	 	+ 	computeGPA() + 		"\n" +
				"Dean List: \t"		 + 	isOnDeansList() +	"\n" +
				"On Probation: \t"	 + 	isOnProbation() + 	"\n"
				
				
				+ result;
		
		
	}
	
	
}



