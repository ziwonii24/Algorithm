import java.io.*;
import java.util.*;
 
public class Solution {
     
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int tc=1;
    int n;
    String str;
    int top = -1;
    int[] stack = new int[2];
     
    void solve() {
        for(tc=1; tc<=10; tc++) {
            stack[0] = 0;
            try {
                n = Integer.parseInt(br.readLine());
                str = br.readLine();            
            } catch (Exception e) {}
             
            st = new StringTokenizer(str, "+");
            while(st.hasMoreTokens()) {
                stack[++top] = Integer.parseInt(st.nextToken());
                if(top == 1) {
                    stack[0] = stack[0] + stack[1];
                    top = 0;
                }
            }
            sb.append("#").append(tc).append(" ").append(stack[0]).append("\n");
        }
        System.out.println(sb);
    } 
     
    public static void main(String[] args) {
        new Solution().solve();
    }
}
