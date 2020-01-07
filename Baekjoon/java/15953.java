import java.util.*;
import java.io.*;

public class Main {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	
	int[][] contest1 = {{1, 500}, {2, 300}, {3, 200}, {4, 50}, {5, 30}, {6, 10}};
	int[][] contest2 = {{1, 512}, {2, 256}, {4, 128}, {8, 64}, {16, 32}};
	
	void solve() throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testcase; tc++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int ans = 0;
			
			if(a > 21) a = 0;
			if(b > 31) b = 0;
			
			if(a != 0) {
				for(int i=0; i<contest1.length; i++) {
					a -= contest1[i][0];
					if(a <= 0) {
						ans += contest1[i][1];
						break;
					}
				}
			}
			
			if(b != 0) {
				for(int i=0; i<contest2.length; i++) {
					b -= contest2[i][0];
					if(b <= 0) {
						ans += contest2[i][1];
						break;
					}
				}
			}
			
			sb.append(ans*10000).append('\n');
		} 
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
