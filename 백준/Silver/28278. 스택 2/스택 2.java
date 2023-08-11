import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>(); 
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if (cmd.equals("1")) {
				stack.push(Integer.parseInt(st.nextToken()));
				
			} else if (cmd.equals("2")) {
				bw.write(stack.empty() ? "-1\n" : stack.pop() + "\n"); 
						
			} else if (cmd.equals("3")) {
				bw.write(stack.size() + "\n");
				
			} else if (cmd.equals("4")) {
				bw.write(stack.empty() ? "1\n" : "0\n");
				
			} else if (cmd.equals("5")) {
				bw.write(stack.empty() ? "-1\n" : stack.peek() + "\n");
			}
		}
		
		br.close();
		bw.close();
	}
}
