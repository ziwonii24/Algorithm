import java.util.*;
import java.io.*;

class Pair {
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n;
	Pair company, home;	// 회사,집
	Pair[] arr;			// 고객들
	boolean[] check;
	int min = Integer.MAX_VALUE;
	
	int distance(Pair p1, Pair p2) {
		return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
	}
	
	void dfs(Pair from, int dist, int cnt) {
		if(min < dist) return;			// 이미 min값보다 커지면 더이상 의미가 없으므로 return		
		if(cnt==n) {					// n개를 다 돌았으면 return
			dist += distance(from, home);	// 마지막 고객에서 집까지의 거리
			min = dist<min?dist:min;
			return;
		}
				
		for(int to=0; to<n; to++) {
			if(!check[to]) {
				check[to] = true;
				dfs(arr[to], dist+distance(from, arr[to]), cnt+1);
				check[to] = false;
			}
		}
	}
	
	void solve() {
		try {
			int testcase = Integer.parseInt(br.readLine());
			for(int tc=1; tc<=testcase; tc++) {
				n = Integer.parseInt(br.readLine());
				arr = new Pair[n];
				check = new boolean[n];
				min = Integer.MAX_VALUE;
				st = new StringTokenizer(br.readLine(), " ");
				company = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				home = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				for(int i=0; i<n; i++) {
					arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}
				dfs(company,0,0);
				sb.append("#").append(tc).append(" ").append(min).append("\n");
			}
			System.out.println(sb);
			
		} catch(IOException e) {}
	}
	
	public static void main(String[] args) {
		new Solution().solve();
	}
}
