package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class PhoneList01 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			File file = new File("phone.txt");
			if(!file.exists()) { //파일이 존재하니
				System.out.println("file 없소");
				return;
			}
			System.out.println("===========파일 정보==========");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length()+"bytes");
			System.out.println(file.lastModified()); //파일 정보
			
			System.out.println("===========전화번호==========");
			// 1.기반 스트림 선정(표준입력,stdin,System.in(자바))
			FileInputStream fis = new FileInputStream(file);
			// 2.보조 스트림1(키보드에서 입력받는 byte|byte|byte -> char 변경)
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			// 3.보조 스트림2(char1|char2|char3|char4|\n -> "char1char2char3char4")
			br = new BufferedReader(isr);
			
			//4.처리
			String line=null;
			while((line = br.readLine())!=null) {
				//Tokenizer
				StringTokenizer st = new StringTokenizer(line,"\t ");
				int index =0;
				while(st.hasMoreElements()) {
					String token = st.nextToken(); //토큰 값 받기
					if(index==0) { //이름
						System.out.print(token+":");
					}else if(index==1) { //전화번호1
						System.out.print(token+"-");
					}else if(index==2) { //전화번호2
						System.out.print(token+"-");
					}else{ 
						System.out.print(token+"");
					}
					index++;
					
				}
				System.out.println("");
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
