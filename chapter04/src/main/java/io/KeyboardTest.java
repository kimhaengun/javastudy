package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class KeyboardTest {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			// 1.기반 스트림 선정(표준입력,stdin,System.in(자바))
			// 2.보조 스트림1(키보드에서 입력받는 byte|byte|byte -> char 변경)
			InputStreamReader isr = new InputStreamReader(System.in, "utf-8");
			// 3.보조 스트림2(char1|char2|char3|char4|\n -> "char1char2char3char4")
			br = new BufferedReader(isr);
			String line=null;
			while((line = br.readLine())!=null) {
				if("quit".equals(line)) {
					break;
				}
				System.out.println(line);
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println("error:"+e);
		}catch (IOException e) { //readLine
			// TODO Auto-generated catch block
			System.out.println("error:"+e);
		}finally {
			try {
				if(br!=null) {
					br.close();	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
