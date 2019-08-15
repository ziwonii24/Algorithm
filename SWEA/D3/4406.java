import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Solution {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int testcase;
	
	void solve() {
		try {
			testcase = Integer.parseInt(br.readLine());
			for(int tc=1; tc<=testcase; tc++) {
				sb.append("#").append(tc).append(" ");
				String str = br.readLine();
				for(char c: str.toCharArray()) {
					if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
						continue;
					sb.append(c);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			
		} catch(IOException e) {}
	}
	
	public static void main(String[] args) {
		new Solution().solve();
	}
}
