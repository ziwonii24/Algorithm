import java.io.*;
import java.util.*;

class Pair {
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	final int dx[] = {0,0,1,-1};
	final int dy[] = {1,-1,0,0};
	int n;
	int[][] arr, vis;
	Set<Integer> set = new HashSet<>();
	List<Integer> list = new ArrayList<>();	// 높이 오름차순 모음
	int safe_cnt = 1;	// 아무지역도 물에 잠기지 않을 경우, 안전영역은 무조건 1개
	int height = 100;	
	
	void init() {
		try {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			vis = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					set.add(arr[i][j]);
					if(arr[i][j] < height) {
						height = arr[i][j];	// 높이 최소값 구하기
					}
				}
			}
			
			for(int s: set) {
				list.add(s);
			}
			Collections.sort(list);
//			System.out.println("list="+list);
			
		} catch(IOException e) {}
	}
	
	void init_vis() {
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				vis[i][j] = 0;
	}
	
	void bfs(int x, int y, int cnt, int rain) {
//		System.out.println("bfs(i, j, cnt, rain)="+x+","+y+","+cnt+","+rain);
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		if(rain<arr[x][y]) 
			vis[x][y] = cnt;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			for(int k=0; k<4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(vis[nx][ny]==0 && rain<arr[nx][ny]) {
						vis[nx][ny] = cnt;
						q.add(new Pair(nx, ny));
					}
				}
			}
		}
//		print(vis);
	}
	
	void solve() {
		init();
		for(int k=0; k<list.size(); k++) {
			int cnt = 0;
			init_vis();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(vis[i][j]==0 && list.get(k)<arr[i][j]) {
						bfs(i, j, ++cnt, list.get(k));
					}
				}
			}
//			System.out.println("cnt = "+cnt);
			if(safe_cnt < cnt) {
				safe_cnt = cnt;
			}
//			print(vis);
		}
		
		System.out.println(safe_cnt);
	}
	
	void print(int[][] arr) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(vis[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
