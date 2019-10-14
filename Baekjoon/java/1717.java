import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n, m;
	int[] root;
	
	int find(int x) {
		if(root[x]==-1) {
			return x;
		}
		return root[x] = find(root[x]);
	}
	
	void union(int cmd, int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) {
			if(cmd==0) root[pa] = pb;
			else sb.append("NO").append('\n');
		} else {
			if(cmd==1) sb.append("YES").append('\n');
		}
	}
	
	void solve() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		root = new int[n+1];
		Arrays.fill(root, -1);
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(cmd, a, b);
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
