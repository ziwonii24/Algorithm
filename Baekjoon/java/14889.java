import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int n;
	int[][] arr;
	List<Integer> team_start = new ArrayList<>();
	boolean[] check;
	int ans = Integer.MAX_VALUE;
	
	int team_score(boolean team) {	// true: start, false: link
		int res = 0;
		for(int i=0; i<n; i++) {
			if(check[i]!=team) continue;
			for(int j=0; j<n; j++) {
				if(i!=j && check[j]==team) {
					res += arr[i][j];
				}
			}
		}
		return res;
	}
	
	void comb(int x) {
		if(team_start.size()==n/2) {
			int start = team_score(true);
			int link = team_score(false);
			int diff = Math.abs(start - link);
			if(diff < ans) {
				ans = diff;
			}
			return;
		}
		
		for(int i=x; i<n; i++) {
			if(!check[i]) {
				check[i] = true;
				team_start.add(i);
				comb(i+1);
				check[i] = false;
				team_start.remove(team_start.size()-1);
			}
		}
	}
	
	void solve() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		check = new boolean[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		team_start.add(0);
		check[0] = true;
		comb(1);
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
