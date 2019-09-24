/**************************************************************
    Problem: 2247
    User: chjiiwon30
    Language: Java
    Result: Success
    Time:242 ms
    Memory:14216 kb
****************************************************************/
 
 
import java.util.*;
import java.io.*;
 
/**그리디*/
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
                return Integer.valueOf(o1.s).compareTo(o2.s);
            }
        });
                 
        int s=0, e=0, o=0, x=0;
        for(Node time: list) {
            int ts = time.s;
            int te = time.e;
             
            if(s==0) {
                s = ts;
                e = te;
                continue;
            }
             
            if(ts <= e)  {
                e = e<te?te:e;
            } else {
                o = o<(e-s)?(e-s):o;
                x = x<(ts-e)?(ts-e):x;
                s = ts;
                e = te;
            }
        }
         
        o = o<(e-s)?(e-s):o;
        System.out.println(o + " " + x);
    }   
     
    private static class Node {
        int s, e;
        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
