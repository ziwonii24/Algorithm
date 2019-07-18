import java.util.Scanner;

public class Solution {	// 새로운 불면증 치료법
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int TC=1; TC<=tc; TC++) {
			int n = sc.nextInt();
			int k = 1;
			boolean[] checkNum = new boolean[10];
			while(true) {
				boolean check = true;
				for(int i=0; i<10; i++) {
					if(!checkNum[i]) {
						check = false;
					}
				}
				if(check) {
					break;
				}
				int tmp = n*k;
				while(true) {
					if(tmp == 0) {
						break;
					}
					checkNum[tmp%10] = true;
					tmp /= 10;
				}
				k++;
			}
			System.out.printf("#%d %d\n", TC, n*(k-1));
		}
	}
}
