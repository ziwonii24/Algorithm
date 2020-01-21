import java.util.*;
import java.io.*;

public class Main {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	
	int n, m;
	int[] arr;
	
	void solve() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int result = Arrays.binarySearch(arr, Integer.parseInt(st.nextToken()));
			if(result < 0) {
				sb.append(0).append('\n');
			} else {
				sb.append(1).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
