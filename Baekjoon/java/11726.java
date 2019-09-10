import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n;
	int[] d;
	
	void solve() throws IOException {
		n = Integer.parseInt(br.readLine());
		d = new int[n+1];
		d[1] = 1; d[2] = 2;
		for(int i=3; i<=n; i++) {
			d[i] = (d[i-1] + d[i-2]) % 10007;
		}
		System.out.println(d[n]);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
