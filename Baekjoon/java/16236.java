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
	int n;
	int[][] map, vis;
	Pair shark;
	int shark_size = 2;
	int shark_eating = 0;
	final int[] dx = {0,0,1,-1};
	final int[] dy = {1,-1,0,0};
	List<Pair> fish = new ArrayList<>();	
	int ans_time = 0;
	
	void print(int[][] arr) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==-1) System.out.print("- ");
				else System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	void input() {
		try {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			vis = new int[n][n];
			for(int i=0; i<n; i++) {
				String[] row = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(row[j]);
					if(map[i][j]==9) {
						shark = new Pair(i, j);
						map[i][j] = 0;
					}
				}
			}
		} catch(IOException e) {}
	}
	
	boolean remainFish() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]!=0 && map[i][j]<shark_size) {
					return true;
				}
			}
		}
		return false;
	}
	
	void init_vis() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				vis[i][j] = -1;
			}
		}
	}
	
	void finding() {
		init_vis();
		fish.clear();
		int threshold = -1;	// 먹을 수 있는 물고기를 찾을 경우, 그 물고기의 거리를 저장(그 이후는 보지 않도록)
		Queue<Pair> q = new LinkedList<Pair>();
		
		q.add(shark);
		int x = shark.x;
		int y = shark.y;
//		System.out.println("상어의 위치 : ("+x+", "+y+")");
		vis[x][y] = 0;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			x = p.x;
			y = p.y;
			
//			System.out.println("threshold : "+threshold);
//			System.out.println("===vis===");
//			print(vis);
			if(vis[x][y]==threshold) {
//				System.out.println(threshold+"안에 있는 물고기 다 찾음");
				ans_time += threshold;				
				break;
			}
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(vis[nx][ny]==-1) {
						if(map[nx][ny]!=0 && map[nx][ny] < shark_size) {		
//							System.out.println("먹을수있는 물고기 찾음!");
							vis[nx][ny] = vis[x][y]+1;
							q.add(new Pair(nx, ny));
							fish.add(new Pair(nx, ny));
							threshold = vis[nx][ny];
						} else if(map[nx][ny]==0 || map[nx][ny]==shark_size) {
//							System.out.println("그냥 지나감~");
							vis[nx][ny] = vis[x][y]+1;
							q.add(new Pair(nx, ny));
						}
					}
				}
			}
		}
//		System.out.println("bfs end");
	}
	
	void eating() {		
		// 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
		fish.sort(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.x==o2.x) {
					return Integer.valueOf(o1.y).compareTo(Integer.valueOf(o2.y));
				}
				return Integer.valueOf(o1.x).compareTo(Integer.valueOf(o2.x));
			}			
		});
//		System.out.println("물고기 후보들의 위치 >");
//		for(Pair p: fish) {
//			System.out.println("("+p.x+", "+p.y+")");
//		}
//		Pair target = fish.get(0);
		Pair target = new Pair(fish.get(0).x, fish.get(0).y);
//		System.out.println("먹을 물고기의 위치 : ("+target.x+", "+target.y+")");
		map[target.x][target.y] = 0;	// 먹음
		shark.x = target.x;	// 상어위치 갱신
		shark.y = target.y;
		shark_eating++;		// 상어가 여태 먹은 물고기의 수 1 증가
		if(shark_eating == shark_size) {	// 상어의 크기만큼 먹었으면 크기 1 증가
			shark_size++;
			shark_eating = 0;
		}
	}
	
	void solve() {
		input();
		while(remainFish()) {	// 더이상 먹을 게 없을때까지 진행
//			System.out.println("===map===");
//			print(map);
			finding();
			if(fish.size()==0) {
				break;
			}
			eating();
		}
		System.out.println(ans_time);
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
/*

5
9 6 0 0 1
6 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 1 0
*/
