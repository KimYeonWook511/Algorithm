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
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for (int run = 0; run < n; run++) {
			String line = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				
				if (stack.empty() || stack.peek() != c) stack.push(c);
				else stack.pop();
			}
			
			if (stack.empty()) cnt++;
		}
		
		bw.write(Integer.toString(cnt));
		
		br.close();
		bw.close();
	}
}