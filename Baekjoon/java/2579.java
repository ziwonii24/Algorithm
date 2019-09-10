import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n;
	int[] s;
	int[][] d;
	
	int max(int a, int b) {
		return a<b?b:a;
	}
	
	void solve() throws IOException {
		n = Integer.parseInt(br.readLine());
		s = new int[n+1];
		for(int i=1; i<=n; i++) {
			s[i] = Integer.parseInt(br.readLine());
		}
		
		d = new int[n+1][3];
		d[0][1] = d[0][2] = 0;
		d[1][1] = s[1]; d[1][2] = 0;
		for(int i=2; i<=n; i++) {
			d[i][1] = max(d[i-2][1], d[i-2][2]) + s[i];
			d[i][2] = d[i-1][1] + s[i];
		}
		System.out.println(max(d[n][1], d[n][2]));
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
