package prob04;

public class Depart extends Employee {
	private String department;
	public String getDepartment() {
		return department;
	}
	public Depart(String name, int salary,String department) {
		// TODO Auto-generated constructor stub
		super(name,salary);
		this.department = department;
		this.department = "기획부";
	}
	@Override
	public void getInformation() {
		System.out.println( "이름:" + super.getName() + "연봉:" + super.getSalary() + " 부서:"+department );
		
	}
	
}
