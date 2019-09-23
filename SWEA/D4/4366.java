import java.io.*;
import java.util.*;

public class Solution {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	
	void solve() throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testcase; tc++) {
			String d2 = br.readLine();
			String d3 = br.readLine();
			
			boolean flag = false;
			int d2_10=0, d3_10=0;
			
			for(int i=0; i<d2.length(); i++) {
				char[] d2_tmp = d2.toCharArray();
				if(d2_tmp[i]=='0') {
					d2_tmp[i] = '1';										
				} else {
					d2_tmp[i] = '0';					
				}
				
				d2_10 = Integer.parseInt(String.valueOf(d2_tmp), 2);
				
				for(int j=0; j<d3.length(); j++) {
					char[] d3_tmp = d3.toCharArray();
					for(char k='0'; k<'3'; k++) {
						if(d3_tmp[j]==k) {
							for(int x=1; x<=2; x++) {
								d3_tmp[j] = (char)(((k+x)%3)+'0');
								d3_10 = Integer.parseInt(String.valueOf(d3_tmp), 3);
								if(d2_10 == d3_10) {
									flag = true;
									break;
								}
							}
						}
						if(flag) break;
					}
					if(flag) break;
				}				
				if(flag) break;
			}
			
			if(flag) {
				sb.append('#').append(tc).append(' ').append(d2_10).append('\n');
			}
		}
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}
}
