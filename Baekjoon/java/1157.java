import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	void solve() throws IOException {
		String line = br.readLine();
		line = line.toUpperCase();
		int[] alphabet = new int[26];
		for(char c: line.toCharArray()) {
			alphabet[c-'A'] += 1;
		}
		int max_cnt = 0;
		int max_idx = -1;
		for(int i=0; i<26; i++) {
			if(max_cnt < alphabet[i]) {
				max_cnt = alphabet[i];
				max_idx = i;
			}
		}
		boolean check = true;
		for(int i=0; i<26; i++) {
			if(max_idx != i && max_cnt==alphabet[i]) {
				check = false;
				break;
			}
		}
		if(!check) {
			System.out.println("?");
		} else {
			System.out.println((char)(max_idx+'A'));
		}
	}

	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
