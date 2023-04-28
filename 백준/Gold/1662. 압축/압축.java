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
		
		String str = br.readLine();
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c == ')') {
				int len = 0;
				
				while (stack.peek() != -1) {
					len += stack.pop();
				}
				
				stack.pop(); // -1
				
				len *= stack.pop();
				stack.push(len);
				
			} else if (c == '('){
				stack.push(-1);
				
			} else if (i < str.length() - 1 && str.charAt(i + 1) == '('){
				stack.push(c - '0');
				
			} else {
				stack.push(1);
			}
		}
		
		while (!stack.empty()) {
			result += stack.pop();
		}
		
		bw.write(Integer.toString(result));

		br.close();
		bw.close();
	}
}
