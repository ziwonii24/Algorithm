import java.util.*;
import java.io.*;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int n;
	int[] d;
	
	void solve() throws IOException {
		n = Integer.parseInt(br.readLine());
		d = new int[n+1];
		d[1] = 0;
		
		for(int i=2; i<=n; i++) {
			d[i] = d[i-1]+1; 
			if(i%3==0) {
				if(d[i/3]+1 < d[i]) {
					d[i] = d[i/3]+1; 
				}			
			}
			if(i%2==0) {
				if(d[i/2]+1 < d[i]) {
					d[i] = d[i/2]+1; 
				}			
			}			
		}
		
		System.out.println(d[n]);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
