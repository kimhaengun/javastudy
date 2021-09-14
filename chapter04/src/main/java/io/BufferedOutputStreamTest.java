package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {
	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		try {
			FileOutputStream fos = new FileOutputStream("test.txt");
			//보조 스트림
			bos = new BufferedOutputStream(fos);
			
			for (int i = 97; i <= 122; i++) {
				try {
					bos.write(i);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file 없슴:"+e);
		}finally {
			try {
				if(bos!=null) {
					bos.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
