import java.io.*;
import java.util.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int n=3, m=3;
	int r, c, k;
	int[][] arr;
	int ans_time = 0;
	
	
	void print(int[][] arr) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==-1) System.out.print("- ");
				else System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	void input() {
		try {
			String rck = br.readLine();
			st = new StringTokenizer(rck);
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());			
			arr = new int[n][m];
			for(int i=0; i<n; i++) {
				String row = br.readLine();
				st = new StringTokenizer(row);
				for(int j=0; j<m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
		} catch(IOException e) {}
	}
		
	boolean checkAns() {
		if(r-1<n && c-1<m) {
			if(arr[r-1][c-1]==k) {			
				return true;
			}
		}
		return false;
	}
	
	void operR() {		
		Map<Integer, Integer> map = new HashMap<>();	// 숫자,개수
		List<Integer>[] result = new List[n];	// 행 고정, 열 증가
		
		for(int i=0; i<n; i++) {
			result[i] = new ArrayList<>();
			map.clear();
			for(int j=0; j<m; j++) {
				if(arr[i][j]==0) continue;
				if(map.containsKey(arr[i][j])) {	// 맵이 그 숫자를 이미 가지고 있으면
					map.put(arr[i][j], map.get(arr[i][j])+1);	// 그 숫자의 개수 +1
				} else {
					map.put(arr[i][j], 1);
				}
			}
			// 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬
			result[i] = sorting(map);	
		}
		
		m = result[0].size();
		for(int i=0; i<n; i++) {
			if(m < result[i].size()) {
				m = result[i].size();
			}			
		}
		if(m>100) m=100;
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			int j=0;
			for(int item: result[i]) {				
				arr[i][j++] = item;
				if(j==100) break;
			}
		}
		
//		System.out.println("===R연산결과===");
//		print(arr);
	}
	
	void operC() {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer>[] result = new List[m];	// 열 고정, 행 증가
		
		for(int j=0; j<m; j++) {
			result[j] = new ArrayList<>();
			map.clear();
			for(int i=0; i<n; i++) {
				if(arr[i][j]==0) continue;
				if(map.containsKey(arr[i][j])) {	// 맵이 그 숫자를 이미 가지고 있으면
					map.put(arr[i][j], map.get(arr[i][j])+1);	// 그 숫자의 개수 +1
				} else {
					map.put(arr[i][j], 1);
				}
			}
			// 수의 등장 횟수가 커지는 순으로, 그러한 것이 여러가지면 수가 커지는 순으로 정렬
			result[j] = sorting(map);	
		}
		
		n = result[0].size();
		for(int j=0; j<m; j++) {
			if(n < result[j].size()) {
				n = result[j].size();
			}
		}
		if(n>100) n=100;
		arr = new int[n][m];
		
		for(int j=0; j<m; j++) {
			int i=0;
			for(int item: result[j]) {
				arr[i++][j] = item;
				if(i==100) break;
			}
		}	
		
//		System.out.println("===C연산결과===");
//		print(arr);
	}
	
	List<Integer> sorting(Map<Integer, Integer> map) {
		List<Integer> list = new ArrayList<>();
		list.addAll(map.keySet());
//		System.out.println(list);
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Integer.valueOf(map.get(o1)).equals(map.get(o2))) {
					return Integer.valueOf(o1).compareTo(o2);
				}
				return Integer.valueOf(map.get(o1)).compareTo(map.get(o2));
			}
		});
		List<Integer> result = new ArrayList<>();
		for(int key: list) {
			result.add(key);
			result.add(map.get(key));
		}
		
		return result;
	}
	
	void solve() {		
//		Map<Integer, Integer> map = new HashMap<>();
//		map.put(3, 3); map.put(1, 3); map.put(4, 3);
//		map.put(2, 3); map.put(100, 3); map.put(44, 3);
//		map.put(5, 3); map.put(120, 3); map.put(0, 3);
//		List<Integer> result = sorting(map);
//		System.out.println(result);
		input();
		while(!checkAns()) {
			ans_time++;
			if(ans_time > 100) break;
			if(m <= n) {	// 행열 같거나, 행이 더 길때
				operR();				
			} else {		// 열이 더 길때
				operC();				
			}
		}
		System.out.println(ans_time>100?-1:ans_time);
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}
