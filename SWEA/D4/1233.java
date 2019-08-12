import java.io.*;
import java.util.*;

public class Solution {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	StringBuilder sb = new StringBuilder();
	int n;
	int[] arr;
	
	void init() {
		try {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			for(int i=1; i<=n; i++) {
				String[] line = br.readLine().split(" ");
				if(line.length==4) {
					if(line[1].equals("+")) arr[i] = 201; 
					else if(line[1].equals("-")) arr[i] = 202; 
					else if(line[1].equals("*")) arr[i] = 203; 
					else if(line[1].equals("/")) arr[i] = 204;
					int a = Integer.parseInt(line[2]);				
					int b = Integer.parseInt(line[3]);
					arr[a] = a;
					arr[b] = b;
				} else {
					if(line[1].equals("+")) arr[i] = 201; 
					else if(line[1].equals("-")) arr[i] = 202; 
					else if(line[1].equals("*")) arr[i] = 203; 
					else if(line[1].equals("/")) arr[i] = 204;
					else arr[i] = Integer.parseInt(line[1]);
				}
			}			
		} catch(IOException e) {}
	}
	
	boolean check() {
		int oper = 0;
		int oper_idx = 0;
		for(int i=1; i<=n; i++) {
			if(arr[i]>=201) {
				oper++;
				oper_idx = i;
			} else {
				break;
			}
		}
		int num = 0;
		int num_idx = 0;
		for(int i=oper_idx+1; i<=n; i++) {
			if(arr[i]<=200) {
				num++;
				num_idx = i;
			} else {
				break;
			}
		}
		
		if(num_idx==n) return true;
		if(oper+1==num) return true;
		return false;
	}
		
	void solve() {
		int tc=1;
		while(tc<=10) {
			init();
			int ans = check()?1:0;
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			tc++;
		}		
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		new Solution().solve();		
	}
}
