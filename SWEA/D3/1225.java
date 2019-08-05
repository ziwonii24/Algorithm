import java.io.*;
import java.util.*;

public class Solution {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuffer sb = new StringBuffer();
	
	void solve() {
		for(int tc=1; tc<=10; tc++) {
			Queue<Integer> q = new LinkedList<>();
			int minus = 1;
			
			try {
				int testcase = Integer.parseInt(br.readLine());
				String[] input = br.readLine().split(" ");
				for(int i=0; i<8; i++) {
					q.add(Integer.parseInt(input[i]));
				}
			} catch(IOException e) {}
			
			while(true) {
				if(minus > 5) {
					minus = 1;
				}
				int first = q.poll();
				int next = first - minus;
				if(next <= 0) {
					q.add(0);
					break;
				}
				q.add(next);
				minus++;
			}
			
			sb.append("#").append(tc).append(" ");
			for(int i: q) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		new Solution().solve();		
	}
}
