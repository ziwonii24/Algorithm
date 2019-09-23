import java.io.*;
import java.util.*;

/*
(R,C,S) 조합 만들어서 완전탐색
*/
public class Solution {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n, m;
	String[] master, me;	
	List<Integer> stack = new ArrayList<>();
	int[] ans;
		
	void stylish(int R, int C, int S) {
		int a=0, b=0, c=0, d=0, e=0, f=0;
		for(int i=0; i<n; i++) {
			String line = master[i];
			int dot = 0;
			int j = 0;
			for(j=0; j<line.length(); j++) {
				if(line.charAt(j)=='.') {
					dot+=1;
				} else {
					break;
				}
			}
			
			int expDot = R*(a-b) + C*(c-d) + S*(e-f);
			if(expDot != dot) {
				return;
			}
			
			for(; j<line.length(); j++) {
				char w = line.charAt(j);
				if(w=='(') a+=1;
				else if(w==')') b+=1;
				else if(w=='{') c+=1;
				else if(w=='}') d+=1;
				else if(w=='[') e+=1;
				else if(w==']') f+=1;
			}
		}
		
		a=0; b=0; c=0; d=0; e=0; f=0;
		for(int i=0; i<m; i++) {
			String line = me[i];
			int dot = R*(a-b) + C*(c-d) + S*(e-f);
			if(ans[i]==-2) {
				ans[i] = dot;
			} else if(ans[i] != dot) {
				ans[i] = -1;
			}
			for(int j=0; j<line.length(); j++) {
				char w = line.charAt(j);
				if(w=='(') a+=1;
				else if(w==')') b+=1;
				else if(w=='{') c+=1;
				else if(w=='}') d+=1;
				else if(w=='[') e+=1;
				else if(w==']') f+=1;
			}
		}
	}
	
	void dfs() {
		if(stack.size()==3) {
			stylish(stack.get(0), stack.get(1), stack.get(2));
			return;
		}
		
		for(int i=1; i<=20; i++) {
			stack.add(i);
			dfs();
			stack.remove(stack.size()-1);
		}
	}
	
	void solve() throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testcase; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());	// master
			m = Integer.parseInt(st.nextToken());	// me
			master = new String[n];
			me = new String[m];
			ans = new int[m];
			Arrays.fill(ans, -2);
			for(int i=0; i<n; i++) {
				master[i] = br.readLine();
			}
			for(int i=0; i<m; i++) {
				me[i] = br.readLine();
			}
			
			dfs();	
			sb.append('#').append(tc).append(' ');
			for(int i=0; i<m; i++) {
				sb.append(ans[i]).append(' ');
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}

}
