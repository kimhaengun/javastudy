package chapter03;

public class Student extends Person {
	private int grade;//학년
	private String major;//전공
	
	public Student() {
		System.out.println("Student() called");
	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}
