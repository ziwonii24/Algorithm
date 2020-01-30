import java.util.*;
import java.io.*;

public class Main {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	
	int n;
	char[][] arr, copy_arr;
	int ans = 0;
	
	void copyArr() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				copy_arr[i][j] = arr[i][j];
			}
		}
		
//		System.out.println("***copied arr***");
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(copy_arr[i][j]);
//			}
//			System.out.println();
//		}
	}
	
	void rotateArr() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				copy_arr[j][i] = arr[i][j];
			}
		}
		
//		System.out.println("***rotated arr***");
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(copy_arr[i][j]);
//			}
//			System.out.println();
//		}
	}
	
	void swap(int r, int c1, int c2) {
		char temp = copy_arr[r][c1];
		copy_arr[r][c1] = copy_arr[r][c2];
		copy_arr[r][c2] = temp;
	}
	
	void howLong(int r, int[] c) {
//		System.out.println("===how long 시작===");
		char[] target = {copy_arr[r][c[0]], copy_arr[r][c[1]]};
		
		for(int k=0; k<2; k++) {
			int sum = 1;
		
//			System.out.println("--"+(k+1)+"번째--");
			for(int i=r-1; i>=0; i--) {
				if(copy_arr[i][c[k]] != target[k]) {
					break;
				}
				sum += 1;
			}
//			System.out.println("위로 sum: "+ sum);
			
			for(int i=r+1; i<n; i++) {
				if(copy_arr[i][c[k]] != target[k]) {
					break;
				}
				sum += 1;
			}
//			System.out.println("아래로 sum: "+ sum);
			
			if(ans < sum) {
				ans = sum;
			}
		}
	}
	
	void solve() throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		copy_arr = new char[n][n];
		for(int i=0; i<n; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<n; j++) {
				arr[i][j] = line[j];
				copy_arr[i][j] = arr[i][j];
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				howLong(i, new int[]{j, j+1});
			}
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				rotateArr();
				howLong(i, new int[]{j, j+1});
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				copyArr();
				swap(i, j, j+1);
				howLong(i, new int[]{j, j+1});
			}
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				rotateArr();
				swap(i, j, j+1);
				howLong(i, new int[]{j, j+1});
			}
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
}
