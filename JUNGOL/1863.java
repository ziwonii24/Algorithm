import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n, m;
	int[] root;
	Set<Integer> set = new HashSet<>();
	
	int find(int a) {
		if(root[a]==a) return root[a];
		return root[a] = find(root[a]);
	}
	
	void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) {
			root[pb] = pa;
			set.add(root[pb]);
		}
	}
	
	void solve() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		root = new int[n+1];
		for(int i=1; i<=n; i++) {
			root[i] = i;
		}
		
		for(int i=0; i<m; i++) {			
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		sb.append(set.size());
		System.out.println(sb);
	}
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
