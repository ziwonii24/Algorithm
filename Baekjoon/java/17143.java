import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n, m, c;	// row col cnt
	Shark[][] map, moved;
	final int[] dx = {-1,1,0,0};	// 1 2 3 4
	final int[] dy = {0,0,1,-1};	// 위 아 오 왼
	int ans = 0;
			
	void init() {
		try {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map = new Shark[n+1][m+1];
			moved = new Shark[n+1][m+1];
			for(int i=0; i<c; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = new Shark(
						Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken()));
			}
		} catch(IOException e) {}
	}
	
	void catching(int col) { // 낚시왕이 있는 열에서 땅과 가장 가까운 상어 잡기		
		for(int i=1; i<=n; i++) {
			if(map[i][col]!=null) {
				ans += map[i][col].z;	// 잡은 상어 크기 더하기
				map[i][col] = null;	// 상어 없애기
				break;
			}
		}
	}
	
	void arrived(int x, int y, int nx, int ny) {
		// (x, y) : 원래 있던 곳, (nx, ny) : 도착할 곳
		if(moved[nx][ny]!=null) {	// 이미 상어가 있으면
			if(moved[nx][ny].z < map[x][y].z) {	// 나중에 온 상어가 더 크면 잡아먹기
				moved[nx][ny] = map[x][y];
			}	// 아니면 업데이트할 필요 x
		} else {	// 도착한 곳이 빈자리면
			moved[nx][ny] = map[x][y];
		}		
		map[x][y] = null;	// 원래 있던 자리 비우기
	}
	
	void moving() {
		for(int i=0; i<=n; i++) {
			Arrays.fill(moved[i], null);			
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(map[i][j]!=null) {	// 상어가 있으면
					int speed = map[i][j].s;	// 해당 상어의 속도
					int dir = map[i][j].d-1;	// 해당 상어의 방향
					int nx = i;	// 현재 상어의 위치에서부터 이동하기 위해
					int ny = j;
					
					if(speed==0) {
						arrived(i, j, nx, ny);
						continue;
					}
					
					for(int k=1; k<=speed; k++) {	// 속도만큼 칸이동							
						nx += dx[dir];
						ny += dy[dir];
											
						if(nx<=0 || nx>n || ny<=0 || ny>m) {	// 경계 밖으로 나가면
							// 방향바꾸기
							if(dir%2==0) dir += 1;
							else dir -= 1;
							map[i][j].d = dir+1;
							// 뒤로 두칸 후진
							nx += dx[dir]*2;
							ny += dy[dir]*2;
						}
												
						if(k==speed) {	// 마지막 번째에 도착
							arrived(i, j, nx, ny);
						}						
					}					
				}
 			}
		}
				
		for(int i=1; i<=n; i++) {	// 원래 맵으로 복사
			for(int j=1; j<=m; j++) {
				map[i][j] = moved[i][j];
			}
		}
	}
	
	void solve() {
		init();
		if(c!=0) {
			for(int col=1; col<=m; col++) {	// 낚시왕 1부터 m까지 이동 = 시간(초)
				catching(col);
				moving();		
			}
		}		
		sb.append(ans);
		System.out.println(sb);
	}
	
	class Shark {
		int s, d, z;	// speed dir size
		public Shark(int s, int d, int z) {
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
