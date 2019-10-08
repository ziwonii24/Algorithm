import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int n;
	Pair[] locs;
	PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2)->Double.valueOf(o1.weight).compareTo(o2.weight));
	int[] root;
	double ans = 0;
	
	private class Edge {
		int s1, s2;	// 별의 인덱스
		double weight;
		public Edge(int s1, int s2, double weight) {
			this.s1 = s1;
			this.s2 = s2;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Edge [s1=" + s1 + ", s2=" + s2 + ", weight=" + weight + "]";
		}	
		
	}
	
	private class Pair {
		double x, y;
		public Pair(double x, double y) {
			this.x = x;
			this.y = y;
		}	
	}
	
	int find(int s) {
		if(root[s]==-1) {
			return s;
		}
		return root[s] = find(root[s]);
	}
	
	boolean union(int s1, int s2) {
		int p1 = find(s1);
		int p2 = find(s2);
		if(p1 != p2) {
			root[p1] = p2;
			return true;
		}
		return false;
	}
	
	void kruskal() {
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			boolean isUnioned = union(edge.s1, edge.s2);
			if(isUnioned) {
				ans += edge.weight;
			}
		}
	}
	
	void solve() throws IOException {
		n = Integer.parseInt(br.readLine());
		locs = new Pair[n];
		root = new int[n];
		Arrays.fill(root, -1);
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			locs[i] = new Pair(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}		
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				double dist = Math.sqrt(Math.pow(locs[i].x-locs[j].x, 2) + Math.pow(locs[i].y-locs[j].y, 2));
				pq.add(new Edge(i, j, dist));
			}
		}
		
		kruskal();
		System.out.println(String.format("%.2f", ans));
	}

	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
