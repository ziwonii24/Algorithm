import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int n, m;
	int[] root;
	int ans = 0;
	PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2)->Integer.valueOf(o1.weight).compareTo(o2.weight));
	
	private class Edge {
		int from, to, weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	int find(int v) {
		if(root[v] == -1) {
			return v;
		}
//		return find(root[v]);
		return root[v] = find(root[v]);
	}
	
	boolean union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		if(p1 != p2) {
			root[p1] = p2;
			return true;
		}
		return false;
	}
	
	void kruskal() {
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			boolean isUnioned = union(edge.from, edge.to);
			if(isUnioned) {
				ans += edge.weight;
			}
		}
	}
	
	void solve() throws IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		root = new int[n+1];
		Arrays.fill(root, -1);
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pq.add(new Edge(
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
					));
		}
	
		kruskal();
		System.out.println(ans);
	}

	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
