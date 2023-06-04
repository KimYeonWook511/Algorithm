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
		Stack<Character> leftStack = new Stack<>();
		Stack<Character> rightStack = new Stack<>();
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < str.length(); i++) {
			leftStack.push(str.charAt(i));
		}
		
		for (int run = 0; run < m; run++) {
			String cmd = br.readLine();
			
			if (cmd.length() > 1) {
				leftStack.push(cmd.charAt(2));
				
			} else if (cmd.equals("L") && !leftStack.isEmpty()) {
				rightStack.push(leftStack.pop());
				
			} else if (cmd.equals("D") && !rightStack.isEmpty()) {
				leftStack.push(rightStack.pop());
				
			} else if (cmd.equals("B") && !leftStack.isEmpty()){
				leftStack.pop();
			}
		}
		
		while (!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}
		
		while (!rightStack.isEmpty()) {
			bw.write(rightStack.pop());
		}
		
		br.close();
		bw.close();
	}
}
