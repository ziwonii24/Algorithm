import java.io.*;
import java.util.*;

/**set을 안쓰니까 시간*/
public class Solution {	
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	
	void solve() throws IOException {
		int testcase = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=testcase; tc++) {
			int n = Integer.parseInt(br.readLine());
			Set<String> name_set = new TreeSet<>();
			for(int i=0; i<n; i++) {
				String name = br.readLine();
				name_set.add(name);
			}			
			List<String> name_list = new ArrayList<>(name_set);
			Collections.sort(name_list);			
			Collections.sort(name_list, (o1, o2)->Integer.valueOf(o1.length()).compareTo(o2.length()));
			
			sb.append('#').append(tc).append('\n');
			for(String name: name_list) {
				sb.append(name).append('\n');
			}
		}
		System.out.print(sb);
	}

	
	public static void main(String[] args) throws IOException {
		new Solution().solve();
	}
}
