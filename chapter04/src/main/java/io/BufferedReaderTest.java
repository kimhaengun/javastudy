package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {
	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			//기반 스트림
			FileReader fr = new FileReader("./src/main/java/io/BufferedReaderTest.java");
			//보조 스트림
			br = new BufferedReader(fr);
			
			int index = 0;
			String line = "";
			while((line=br.readLine())!=null) {
				index++;
				System.out.print(index);
				System.out.print(":");
				System.out.print(line);
				System.out.println("");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 없음:"+e);
		}catch (IOException e) {
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
