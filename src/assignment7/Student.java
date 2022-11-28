package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int studentID;
	private int attemptedCred;
	private int passingCred;
	private double totalGQP;
	private double bearBucksBalance;
	private double cumGPA;
	
	public Student (String initfirstName, String initlastname, int initstuID) {
		this.firstName= initfirstName;
		this.lastName= initlastname;
		this.studentID= initstuID;
	}
	public String getFullName() {
		String result= this.firstName + " "+ this.lastName;
		return result;
	}
	public int getId() {
		return this.studentID;
	}
	public void submitGrade (double grade, int credits) {
		double submitGrade = grade * credits;
		totalGQP+= submitGrade;
		if (grade<1.7) {
			attemptedCred+= credits;
		} if (grade>=1.7) {
			attemptedCred+= credits;
			passingCred = passingCred+credits;
		}
	}
	public int getTotalAttemptedCredits() {
		return passingCred;
	}
	public double calculateGradePointAverage() {
		cumGPA=totalGQP/attemptedCred;
		return cumGPA;
	}
	public String getClassStanding() {
		if (passingCred<30) {
			String first = "First Year";
			return first;
		}else if (passingCred>= 30 && passingCred<60) {
			String second= "Sophomore";
			return second;
		}else if (passingCred>= 60 && passingCred<90) {
			String third = "Junior";
			return third;
		}else { 
			String fourth = "Senior";
			return fourth;
		}
	}
	public boolean isEligibleForPhiBetaKappa() {
		if (attemptedCred >= 98 && this.calculateGradePointAverage ()>=3.6) {
			return true;
		}if (attemptedCred >= 75 && this.calculateGradePointAverage ()>=3.8) {
			return true;
		}else {
			return false;
		}
	}
	public void depositBearBucks(double amount) {
		bearBucksBalance = bearBucksBalance+amount;
	}
	public void deductBearBucks(double amount ) {
		bearBucksBalance = bearBucksBalance-amount;
	}
	public double getBearBucksBalance() {
		return bearBucksBalance; 
	}
	public double cashOutBearBucks() {
		if (bearBucksBalance<=10) {
			bearBucksBalance=0;
			return bearBucksBalance;
		}
		double holderValue = bearBucksBalance;
		bearBucksBalance =0;
		return holderValue-10;
	}
	public Student createLegacy (String firstName, Student other, boolean isHyphenated, int id) {
		if(isHyphenated == true) {
			Student legStudent = new Student (firstName, this.lastName + "-" + other.lastName, id);
			legStudent.depositBearBucks(this.cashOutBearBucks()+other.cashOutBearBucks());
			return legStudent;
		}else {
			Student legStudent = new Student (firstName, this.lastName, id);
			legStudent.depositBearBucks(this.cashOutBearBucks()+other.cashOutBearBucks());
			return legStudent;
		}
	}
	public String toString() {
		String fullName = this.firstName + " " + this.lastName +" " + this.studentID;
		return fullName;
	}
	}
