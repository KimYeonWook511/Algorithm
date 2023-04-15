import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if (cmd.equals("push")) stack.push(Integer.parseInt(st.nextToken()));
			else if (cmd.equals("empty")) bw.write(stack.empty() ? "1\n" : "0\n");
			else if (cmd.equals("size")) bw.write(stack.size() + "\n");
			else if (stack.empty()) bw.write("-1\n");
			else if (cmd.equals("top")) bw.write(stack.peek() + "\n");
			else bw.write(stack.pop() + "\n");
		}
		
		br.close();
		bw.close();
	}
}