package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		//String -> char 치환 = toCharArray
		char[] arr = str.toCharArray();
		//배열을 뒤집은 값 넣을 배열 생성
		char[] result = new char[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			//length = 11-1-0 -->result[10] 값 = arr[0]
			result[arr.length-1-i] = arr[i];
		}
		return result;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}