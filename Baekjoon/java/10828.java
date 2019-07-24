import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> stack = new ArrayList<Integer>();
		
		for(int N=0; N<n; N++) {
			String command = br.readLine();
			String cmd[] = command.split(" ");
			
			if(cmd[0].equals("push")) {
				stack.add(Integer.parseInt(cmd[1]));
			} else if(cmd[0].equals("pop")) {
				if(stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.get(stack.size()-1).toString());
					stack.remove(stack.size()-1);
				}
			} else if(cmd[0].equals("size")) {
				System.out.println(stack.size());
			} else if(cmd[0].equals("empty")) {
				if(stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if(cmd[0].equals("top")) {
				if(stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.get(stack.size()-1).toString());
				}
			}
		}
	}
}
