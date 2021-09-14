package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {
	public static void main(String[] args) {
		Reader in = null;
		InputStream is = null;
		try {
			// 1234.txt 열기
			in = new FileReader("1234.txt");
			// 읽기
			int count = 0;
			int data = -1;
			while((data=in.read())!=-1) {
				//char 캐스팅 = int->char/(디코딩)
				System.out.print((char)data);
				count++;
			}
			System.out.println("");
			System.out.println("count:"+count);
			System.out.println("================");
			//파일 동시에 열기
			count = 0;
			data = -1;
			is = new FileInputStream("1234.txt");
			while((data=is.read())!=-1) {
				System.out.print((char)data);
				count++;
			}
			System.out.println("");
			System.out.println("count:"+count);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 없서:" + e);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error:" + e);
		}  finally {
			try {
				if (in != null) {
					in.close();
				}if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
