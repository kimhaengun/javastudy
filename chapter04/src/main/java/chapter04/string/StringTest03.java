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
		
		
		//String method~
		String s4 = "aBcABCabcAbc";
		//String 길이
		System.out.println("s4 길이 : "+s4.length());
		//String char로 하나빼옴(배열)
		System.out.println("s4 [2]배열값 : "+s4.charAt(2));
		// 특정 문자열이 있는지 확인
		System.out.println("s4 abc 문자 어디 있을까 : "+s4.indexOf("abc"));
		// s4의 [3]~~~~~~값 
		System.out.println("s4 subString : "+s4.substring(3));
		// s4의 [3]~[4]  - [5]의 앞까지만 출력됨.
		System.out.println("s4 subString : "+s4.substring(3,5));
		
		//concat 문자열 붙이기
		String s5 = "   ab    cd   ";
		String s6 = "ewq,kml,nco";
		String s7 = s5.concat(s6);
		System.out.println("String concat : "+s7);
		
		//trim(1) 앞,뒤 공백제거
		System.out.println("공백 제거 :"+s5.trim()+":");
		//replaceAll(2) 공백 제거
		System.out.println("공백 제거 :"+s5.replaceAll(" ", "")+":");
		//split 문자열 나누기
		String[] tokens = s6.split(","); // , 기준으로 문자열 나누기
		for (int i = 0; i < tokens.length; i++) {
			System.out.println("나눈 문자"+i+":"+tokens[i]);	
		}
		//split에 맞는 조건이 문자열에 없을 경우
		String [] tokens2 = s6.split(" ");
		for (int i = 0; i < tokens2.length; i++) {
			System.out.println(tokens2[i]);
		} //근양 원본이 들어옴, null이 아님
		
	}

}
