import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] alpha = new int[26];
		for(int i=0; i<str.length(); i++) {
			alpha[str.charAt(i)-'a']++;
		}
		for(int i=0; i<alpha.length; i++) {
			System.out.print(alpha[i]+" ");
		}
	
	} // end of main
} // end of class
