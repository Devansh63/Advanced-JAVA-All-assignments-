package lab02_DevanshAgrawalCS161;



public class Student {

	//initializing the values
	String name;
	int scores[] = new int[5];

	Student() {
		
		
	}

	//returns score
	public int[] getscores() {
		return scores;
	}

	//returns name
	public String getname() {
		return name;
	}

	//sets the name
	public void setname(String name) {
		this.name = name;
	}

	// Sets scores 
	public void setscores(int[] scores) {
		for (int i = 0; i < this.scores.length; i++) {
			this.scores[i] = scores[i];
		}
	}

	double Avgscore;

	// calculates the average
	public double getAverage() {
		int TotalSum = 0;
		for (int num : scores) {
			TotalSum += num;
		}
		Avgscore = TotalSum * 1.0 / scores.length;
		return Avgscore;
	}

	char G;

	//Sets grade
	public char getGrade() {
		if (Avgscore >= 90) {
			G = 'A';
		} else if (Avgscore >= 80) {
			G = 'B';
		} else if (Avgscore >= 70) {
			G = 'C';
		} else if (Avgscore >= 60) {
			G = 'D';
		} else
			G = 'F';

		return G;
	}

	// Returns output
	public String toString() {
		
		return "Student found: " + name 
				+ ", Average = " + Avgscore 
				+ ", Grade = " + G;
	}
	
	
	public int compareTo(Student stud) {
		if(name.compareTo(stud.name)>0) {
			return 1;
		}
		else if(name.compareTo(stud.name)<0) {
			return -1;
		}
		else return 0;
	}

}
