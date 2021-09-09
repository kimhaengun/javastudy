package chapter03;

public class StudentTest {

	public static void main(String[] args) {
		Student s1 = new Student(); //실행 순서 1.부모 2.자식 생성자
		s1.setGrade(1);
		s1.setMajor("학생");
		//<upcasting>
		//name값은 부모 값 -> 실질적 ((person)s1).setName("둘리"); 
//		s1.setName("둘리"); 
		
		//upcasting(암시적, Implicity)
		Person p1 =s1;
		p1.setName("둘리");
		
		//<downcasting>
		//downcasting(명시적,explicity)
		Student s2 = (Student)p1;
		s2.setMajor("학생");
		
	}

}
