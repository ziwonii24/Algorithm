import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int n;
	boolean[][] apple;	// 사과의 위치
	Pair[] chdir;		// (시간, 방향)
	
	class Pair {
		int time;
		char dir;
		int x, y;
		public Pair(int time, char dir) {
			this.time = time;
			this.dir = dir;
		}
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	void input() throws IOException {
		n = Integer.parseInt(br.readLine());
		apple = new boolean[n+1][n+1];
		int k1 = Integer.parseInt(br.readLine());
		for(int i=0; i<k1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			apple[row][col] = true;
		}
		int k2 = Integer.parseInt(br.readLine());
		chdir = new Pair[k2];
		for(int i=0; i<k2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			chdir[i] = new Pair(t, d);
		}
	}
	
	void solve() throws IOException {
		input();
		
		int x = 1;
		int y = 1;
		int sd = 0;	// 이동해야하는 방향
		int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
		int time = 0;
		int idx = 0;	// chdir index
		Queue<Pair> q = new LinkedList<>();
//		q.add(new Pair(1,1));
		
		while(true) {
//			System.out.println("현재위치=("+x+", "+y+")");
//			System.out.println("- 현재 시간="+time);
//			System.out.println("- 현재 이동해야하는 방향="+sd);
			
			// 벽 부딪히면 끝
			if(x<=0 || x>n || y<=0 || y>n) {
//				System.out.println("- !! 벽에 부딪혀서 끝");
				break;			
			}
			
			// 자기자신 부딪히면 끝
			boolean flag = false;
			for(Pair p: q) {
				if(x==p.x && y==p.y) {
					flag = true;
					break;
				}
			}
			if(flag) {
//				System.out.println("- !! 지몸에 부딪혀서 끝");
				break;
			}
			
			// 사과 있으면 큐에 넣기 & 사과 없애기
			// 사과 없으면 큐에서 빼고 넣기
			if(apple[x][y]) {
				q.add(new Pair(x, y));
				apple[x][y] = false;
			} else {
				q.poll();	
				q.add(new Pair(x, y));
			}
			
			// 방향 바꾸는 시간이 됐으면 방향바꾸기 - 뱀이 바라보는 방향만 바꾸면됨
			if(idx < chdir.length && time == chdir[idx].time) {
				if(chdir[idx].dir=='D') {	// 0,1,2,3
					sd+=1;
					if(sd==4) sd=0;
				} else {					// 3,2,1,0
					sd-=1;
					if(sd==-1) sd=3;
				}
				idx++;
			}
			
			// 시간 증가
			time++;
			
			// 방향대로 움직이기
			x += dir[sd][0];
			y += dir[sd][1];
//			System.out.println("- 다음위치=("+x+", "+y+")");
		}
		
		System.out.println(time);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
