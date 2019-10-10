import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int V, E;
	PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2)->Integer.valueOf(o1.c).compareTo(o2.c));
	int ans = 0;
	int[] root;
	
	class Info {
		int a, b, c;
		public Info(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	int find(int a) {
		if(root[a] == -1) {
			return a;
		}
		return root[a] = find(root[a]);
	}
	
	boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa != pb) {
			root[pa] = pb;
			return true;
		}
		return false;
	}
	
	void kruskal() {
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			boolean isUnioned = union(info.a, info.b);
			if(isUnioned) {
				ans += info.c;
			}
		}
	}
	
	void solve() throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());		
		E = Integer.parseInt(st.nextToken());
		root = new int[V+1];
		Arrays.fill(root, -1);
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pq.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));			
		}
		kruskal();
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
