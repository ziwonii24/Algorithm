import java.io.*;
import java.util.*;

public class Solution {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuffer sb = new StringBuffer();
	int n, m;
	
	void solve() {
		for(int tc=1; tc<=10; tc++) {
			try {
				List<Integer> list = new ArrayList<>();
				n = Integer.parseInt(br.readLine());
				String nums = br.readLine();
				StringTokenizer st = new StringTokenizer(nums);
				for(int i=0; i<n; i++) {
					list.add(Integer.parseInt(st.nextToken()));
				}
				m = Integer.parseInt(br.readLine());
				String[] cmds = br.readLine().split("I ");
				for(int i=1; i<cmds.length; i++) {
					String[] cmd = cmds[i].split(" ");
					int idx = Integer.parseInt(cmd[0]);
					int cnt = Integer.parseInt(cmd[1]);
					for(int j=2; j<2+cnt; j++) {
						list.add(idx++, Integer.parseInt(cmd[j]));
					}
				}
				sb.append("#").append(tc).append(" ");				
				for(int i=0; i<10; i++) {
					sb.append(list.get(i)).append(" ");
				}
				sb.append("\n");
				
			} catch(IOException e) {}
		}
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		new Solution().solve();		
	}
}
