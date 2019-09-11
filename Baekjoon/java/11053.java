import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	int max(int a, int b) {
		return a<b?b:a;
	}
	
	void solve() throws IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] s = new int[n+1];
		for(int i=1; i<=n; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] d = new int[n+1];
		d[1] = 1;
		int ans = 1; 
		for(int i=2; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				if(s[j] < s[i]) {
					d[i] = max(d[i], d[j]+1);
				}
				if(d[i]==0) d[i] = 1;
				ans = max(ans, d[i]);
			}
		}
		System.out.println(ans);
		
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
