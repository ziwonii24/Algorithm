import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n, m;
	int[] arr;
	boolean[] check;
	List<Integer> stack = new ArrayList<>();
	
	
	void dfs() {
		if(stack.size()==m) {
			for(int item: stack) {
				sb.append(item).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		int tmp = -1;
		for(int i=0; i<n; i++) {
			if(!check[i] && tmp != arr[i]) {
				tmp = arr[i];
				check[i] = true;
				stack.add(arr[i]);
				dfs();
				check[i] = false;
				stack.remove(stack.size()-1);
			}
		}
	}
	
	void solve() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		check = new boolean[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs();
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
