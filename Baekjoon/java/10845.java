import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		int lastElement = -1;	// back
		for(int N=0; N<n; N++) {
			
			String command = br.readLine();
			String cmd[] = command.split(" ");
			
			if(cmd[0].equals("push")) {
				lastElement = Integer.parseInt(cmd[1]);
//				System.out.println("*"+lastElement);
				queue.add(lastElement);
			} else if(cmd[0].equals("pop")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.poll());
				}
			} else if(cmd[0].equals("size")) {
				System.out.println(queue.size());
			} else if(cmd[0].equals("empty")) {
				if(queue.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if(cmd[0].equals("front")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.peek());
				}
			} else if(cmd[0].equals("back")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				} else {
					// 구현할 수 없다고 함... 큐에 그러한 메소드가 없다고 함...
					System.out.println(lastElement);
				}
			}
			
		} // end of for(N)		
	} // end of main
} // end of class
