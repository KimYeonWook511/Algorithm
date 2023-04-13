import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int idx = 1;
		
		for (int run = 0; run < n; run++) {
			int num = Integer.parseInt(br.readLine());
			
			if (idx <= num) {
				while (idx <= num) {
					stack.push(idx);
					sb.append("+\n");
					idx++;
				}
				
				stack.pop();
				sb.append("-\n");
				
			} else {
				if (stack.peek() != num) break;
					
				stack.pop();
				sb.append("-\n");
			}
		}
		
		if (stack.empty()) bw.write(sb.toString());
		else bw.write("NO");
		
		br.close();
		bw.close();
	}
}