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

	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int idx = 1;
		Stack<Integer> stack = new Stack<>();
		
		for (int run = 0; run < n; run++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num == idx) {
				idx++;
				
			} else {
				while (!stack.empty() && stack.peek() == idx) {
					stack.pop();
					idx++;
				}
				
				if (num == idx) idx++;
				else stack.push(num);
			}
		}
		
		while (!stack.empty()) {
			if (stack.peek() != idx) break;
			
			stack.pop();
			idx++;
		}
		
		bw.write(stack.empty() ? "Nice" : "Sad");
		
		br.close();
		bw.close();
	}
}