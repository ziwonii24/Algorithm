import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<Integer>();
		
		for(int N=0; N<n; N++) {
			
			String command = br.readLine();
			String cmd[] = command.split(" ");
			
			if(cmd[0].equals("push_front")) {
				
				deque.addFirst(Integer.parseInt(cmd[1]));
				
			} else if(cmd[0].equals("push_back")) {
				
				deque.addLast(Integer.parseInt(cmd[1]));
				
			} else if(cmd[0].equals("pop_front")) {

				if(deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.peekFirst());
					deque.removeFirst();
				}

			} else if(cmd[0].equals("pop_back")) {

				if(deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.peekLast());
					deque.removeLast();
				}

			} else if(cmd[0].equals("size")) {

				System.out.println(deque.size());

			} else if(cmd[0].equals("empty")) {

				if(deque.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}

			} else if(cmd[0].equals("front")) {

				if(deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.peekFirst());
				}

			} else if(cmd[0].equals("back")) {

				if(deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.peekLast());
				}

			}
			
		} // end of for(N)		
	} // end of main
} // end of class
