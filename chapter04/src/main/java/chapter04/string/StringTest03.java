package chapter04.string;

public class StringTest03 {

	public static void main(String[] args) {
//		String s1 = "Hello" + "world" + "Java" + 1.8;
		String s1 = new StringBuffer("Hello ")
		.append("World ")
		.append("Java ")
		.append(1.8)
		.toString();
		
		System.out.println(s1);
		
		//StringBuffer를 꼭 사용해야 할 경우 - 계속 문자 추가할 경우(많은 횟수)
		String s2 = "";
		for (int i = 0; i < 100000; i++) {
			//s2 = s2 + i;  //계속 new하면서 코드가 끝나질않음 (메모리 계속 할당됨 /낭비)
//			s2 =new StringBuffer(s2).append(i).toString();
		}
		
		//위 보다 빠름
		StringBuffer sb2 = new StringBuffer("");
		for (int i = 0; i < 100000; i++) {
			sb2.append(i);
		}
		
		String s3 = sb2.toString();
		System.out.println(s3.length());
	}

}
