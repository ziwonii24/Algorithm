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
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] d = new int[n+1];
		d[1] = arr[1];
		int ans = d[1];
		for(int i=1; i<=n; i++) {
			d[i] = max(d[i-1]+arr[i], arr[i]);
			ans = max(d[i], ans);
		}		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
