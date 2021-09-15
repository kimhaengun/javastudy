package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.next();
		
		try {
			InetAddress[] inetAddress = InetAddress.getAllByName(line);
			for(InetAddress s : inetAddress) {
				System.out.println(s);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
