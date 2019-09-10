import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n;
	int[][] cost;
	int[][] d;
	
	int min(int a, int b) {
		return a>b?b:a;
	}
	
	void solve() throws IOException {
		n = Integer.parseInt(br.readLine());
		cost = new int[n][3];
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			cost[i][0] = Integer.parseInt(str[0]);
			cost[i][1] = Integer.parseInt(str[1]);
			cost[i][2] = Integer.parseInt(str[2]);			
		}
		
		d = new int[n][3];
		d[0][0] = cost[0][0];
		d[0][1] = cost[0][1];
		d[0][2] = cost[0][2];
		for(int i=1; i<n; i++) {
			d[i][0] = min(d[i-1][1], d[i-1][2]) + cost[i][0];
			d[i][1] = min(d[i-1][2], d[i-1][0]) + cost[i][1];
			d[i][2] = min(d[i-1][0], d[i-1][1]) + cost[i][2];
		}
		System.out.println(min(d[n-1][0], min(d[n-1][1], d[n-1][2])));
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
