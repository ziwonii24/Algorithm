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
	int n, m, d;
	int[][] map, map_copy, vis;
	Stack<Integer> stack = new Stack<>();
	boolean[] check;
	boolean[][] target;
	final int[] dx = {0,-1,0};
	final int[] dy = {-1,0,1};
	int ans = 0;
	
 	void input() {
		try {
			String nmd = br.readLine();
			StringTokenizer st = new StringTokenizer(nmd);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			map_copy = new int[n][m];
			check = new boolean[m];
			target = new boolean[n][m];
			vis = new int[n][m];
			for(int i=0; i<n; i++) {
				String row = br.readLine();
				st = new StringTokenizer(row);
				for(int j=0; j<m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
		} catch(IOException e) {}
	}
 	
 	void init_vis() {	
 		for(int i=0; i<n; i++) {
 			for(int j=0; j<m; j++) {
 				vis[i][j] = 0;
 			}
 		}
 	}
 	
 	void init_target() {	
 		for(int i=0; i<n; i++) {
 			for(int j=0; j<m; j++) {
 				target[i][j] = false;
 			}
 		}
 	}
 	
 	void bfs(int y) {	// 제거될 적 후보 추려내기
 		init_vis();	// 각 궁수가 방문한 배열 기록 초기화
// 		System.out.println("궁수 번호 : " + y);
 		int x = n-1;
 		Queue<Pair> q = new LinkedList<Pair>();
 		q.add(new Pair(x, y));
 		vis[x][y] = 1;
 		if(map_copy[x][y]==1) {
 			target[x][y] = true;
 			return;
 		}
 		
 		while(!q.isEmpty()) {
 			Pair p = q.poll();
 			x = p.x;
 			y = p.y;
 			
 			if(vis[x][y]+1 > d) {
 				break;
 			}
 			 			
 			boolean flag = false;
 			for(int k=0; k<3; k++) {
 				int nx = x + dx[k];
 				int ny = y + dy[k];
 				if(nx>=0 && nx<n && ny>=0 && ny<m) {
 					if(vis[nx][ny]==0) {
 						vis[nx][ny] = vis[x][y] + 1;
 						
 						if(map_copy[nx][ny]==1) {
	 						target[nx][ny] = true;
	 						flag = true;
	 						break;
 						} else {
 							q.add(new Pair(nx, ny));
 						}
 					}
 				}
 			}
 			if(flag) {
 				break;
 			}
 		}
 	}
 	
 	int removeTarget() {
 		int cnt = 0;
 		for(int i=0; i<n; i++) {
 			for(int j=0; j<m; j++) {
 				if(target[i][j]) {
 					cnt++;
 					map_copy[i][j] = 0;
 				}
 			}
 		} 		
 		return cnt;
 	}
 	
 	void go() {
 		for(int i=n-2; i>=0; i--) {
 			for(int j=0; j<m; j++) {
 				map_copy[i+1][j] = map_copy[i][j];
 			}
 		}
 		for(int j=0; j<m; j++) {
 			map_copy[0][j] = 0;
 		}
 	}
 	
 	boolean remainTarget() {
 		for(int i=0; i<n; i++) {
 			for(int j=0; j<m; j++) {
 				if(map_copy[i][j]==1) {
 					return true;
 				}
 			}
 		}
 		return false;
 	}

 	void copyMap() {
 		for(int i=0; i<n; i++) {
 			for(int j=0; j<m; j++) {
 				map_copy[i][j] = map[i][j];
 			}
 		}
 	}
 	
 	void print(int[][] arr) {
 		for(int i=0; i<n; i++) {
 			for(int j=0; j<m; j++) {
 				System.out.print(arr[i][j]+" ");
 			}
 			System.out.println();
 		}
 	}
 	
 	void print(boolean[][] arr) {
 		for(int i=0; i<n; i++) {
 			for(int j=0; j<m; j++) {
 				System.out.print(arr[i][j]?1+" ":0+" ");
 			}
 			System.out.println();
 		}
 	}
 	
	void dfs(int x) {	// 궁수배치
		if(stack.size()==3) {
			copyMap();
			
//			System.out.print("궁수 후보 : [ ");
//			for(int item: stack) {
//				System.out.print(item+" ");
//			}
//			System.out.println("]");	
			
			int cnt = 0;		
//			System.out.println("==map_copy start!!!==");
//			print(map_copy);
			while(remainTarget()) {
				init_target();
				for(int item: stack) {					
					bfs(item);
//					System.out.println("==target==");
//					print(target);
				}	
				
//				System.out.println("==target total!!!==");
//				print(target);
				
				cnt += removeTarget();
				
//				System.out.println("==적 없앤 후==");
//				print(map_copy);
				
				go();
				
//				System.out.println("==한 칸 전진 후==");
//				print(map_copy);
			}
			
//			System.out.println("이 궁수후보가 공격한 적의 수 : "+cnt);
			if(ans < cnt) {
				ans = cnt;
			}
//			System.out.println("ans = "+ans);
			
			return;
		}
		
		for(int i=x; i<m; i++) {
			if(!check[i]) {
				check[i] = true;
				stack.add(i);
				dfs(i+1);
				check[i] = false;
				stack.pop();
			}
		}
	}
	
	void solve() {
		input();
		dfs(0);
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
