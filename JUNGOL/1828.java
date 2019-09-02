import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n;
	List<Node> list = new ArrayList<>();
	int start=-300, end=-300;	// 범위 밖으로 초기화
	
	void solve() throws IOException {
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Node(x, y));
		}
		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return Integer.valueOf(o1.x).compareTo(o2.x);
			}
			
		});
		int cnt = 0;
		for(Node item: list) {			
			if(start==-300) {
				cnt+=1;
				start = item.x;
				end = item.y;
				continue;
			}
			
			if(end < item.x) {
				cnt+=1;
				start = item.x;
				end = item.y;
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
	
	class Node {
		int x, y;
		public Node(int x, int y ) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
