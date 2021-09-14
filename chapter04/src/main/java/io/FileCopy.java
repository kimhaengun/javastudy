package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		// I/O 시 try catch는 필수
		try {
			//에러시 is는 null상태
			// 1.읽을 파일 설정
			is = new FileInputStream("loopy.jpg");
			// 2.쓰는 파일 설정
			os = new FileOutputStream("loopy.copy.jpg");
			//파일 읽기 (int)
			int data = 0;
			while((data=is.read()) != -1) {
				//파일 쓰기
				os.write(data);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일 없서 : "+e);
		}catch (IOException e) {
			System.out.println("error : "+e);
		}finally {
			try {
				//파일이 있을 경우에만
				if (is!=null) {
					is.close();	
				}
				if (os!=null) {
					os.close();	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//자원 정리
		
		
	}
}
