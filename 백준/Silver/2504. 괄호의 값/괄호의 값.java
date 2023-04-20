import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		String line = br.readLine();
		Stack<Integer> stack = new Stack<>();
		int cal = 0;

		for (int run = 0; run < line.length(); run++) {
			char c = line.charAt(run);

			if (c == '(') {
				stack.push(-1);

			} else if (c == '[') {
				stack.push(-2);

			} else if (c == ')') {
				if (stack.empty()) {
					stack.push(-3);
					break;
				}

				cal = 0;

				while (stack.peek() > 0) {
					cal += stack.pop() * 2;
					
					if (stack.empty()) {
						stack.push(-3);
						break;
					}
				}

				if (stack.pop() == -1) {
					stack.push(cal == 0 ? 2 : cal);

				} else {
					stack.push(-3);
					break;
				}

			} else {
				// c == ']'
				if (stack.empty()) {
					stack.push(-3);
					break;
				}

				cal = 0;
				
				while (stack.peek() > 0) {
					cal += stack.pop() * 3;
					
					if (stack.empty()) {
						stack.push(-3);
						break;
					}
				}
				
				if (stack.pop() == -2) {
					stack.push(cal == 0 ? 3 : cal);

				} else {
					stack.push(-3);
					break;
				}
			}
		}

		cal = 0;
		
		while (!stack.empty()) {
			int n = stack.pop();
			
			if (n < 0) {
				cal = 0;
				break;
			}
			
			cal += n;
		}
		
		bw.write(Integer.toString(cal));
		
		br.close();
		bw.close();
	}
}