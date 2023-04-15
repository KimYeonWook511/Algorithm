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

		while (true) {
			String line = br.readLine();
			
			if (line.equals(".")) break;
			
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			
			for (int i = 0; i < line.length(); i++) {
				if (!flag) break;
				
				char a = line.charAt(i);
				
				if (a == '(') {
					stack.push(a);
					
				} else if (a == ')') {
					if (stack.empty() || stack.pop() != '(') flag = false;
					
				} else if (a == '[') {
					stack.push(a);
					
				} else if (a == ']') {
					if (stack.empty() || stack.pop() != '[') flag = false;
					
				}
			}
			
			if (stack.empty() && flag) bw.write("yes\n");
			else bw.write("no\n");
		}

		br.close();
		bw.close();
	}
}