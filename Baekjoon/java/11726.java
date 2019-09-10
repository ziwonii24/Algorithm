import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	void solve() throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[n+1];
		d[0] = 1; d[1] = 1;
		for(int i=2; i<=n; i++) {
			d[i] = (d[i-1] + d[i-2]) % 10007;
		}
		System.out.println(d[n]);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
