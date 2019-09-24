import java.util.*;
import java.io.*;

/***/
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		List<Node> list = new ArrayList<>();
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(Integer.valueOf(o1.e).equals(o2.e))
					return Integer.valueOf(o1.s).compareTo(o2.s);
				return Integer.valueOf(o1.e).compareTo(o2.e);
			}			
		});
		
		int ans = 0;
		int end = -1;
		for(Node time: list) {
			int ts = time.s;
			int te = time.e;
			
			if(end==-1) {
				end = te;
				ans += 1;
				continue;
			}
			
			if(end <= ts) {
				end = te;
				ans += 1;
			}
		}
		
		System.out.println(ans);
	}	
	
	private static class Node {
		int s, e;
		public Node(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
}
