package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PhoneList02 {
	public static void main(String[] args) {
		Scanner scanner =null;
		try {
			File file = new File("phone.txt");
			if(!file.exists()) { //파일이 존재하니
				System.out.println("file 없소");
				return;
			}
			System.out.println("===========파일 정보==========");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length()+"bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified()))); //파일 정보
			
			System.out.println("===========전화번호==========");
			scanner = new Scanner(file);
			
			System.out.println(scanner.hasNextLine());
			
			while(scanner.hasNextLine()) {
				String name = scanner.next();
				String phone01 = scanner.next();
				String phone02 = scanner.next();
				String phone03 = scanner.next();

				System.out.println(name + ":" + phone01 + "-" + phone02 + "-" + phone03);
			}
			
			
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("파일이 읎다"+e);
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("오류 왜뜸? : "+e);
		}finally {
			if(scanner!=null) {
				scanner.close();
			}
					
			
		}
			
	}
}
