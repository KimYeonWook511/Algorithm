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
		
		int t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			String l = br.readLine();
			Stack<Character> leftStack = new Stack<Character>();
			Stack<Character> rightStack = new Stack<Character>();
			
			for (int i = 0; i < l.length(); i++) {
				char c = l.charAt(i);
				
				if (c == '-') {
					if (!leftStack.isEmpty()) leftStack.pop();
					
				} else if (c == '<') {
					if (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
					
				} else if (c == '>') {
					if (!rightStack.isEmpty()) leftStack.push(rightStack.pop());
					
				} else {
					leftStack.push(c);
				}
			}
			
			while (!leftStack.isEmpty()) {
				rightStack.push(leftStack.pop());
			}
			
			while (!rightStack.isEmpty()) {
				bw.write(rightStack.pop());
			}
			
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}