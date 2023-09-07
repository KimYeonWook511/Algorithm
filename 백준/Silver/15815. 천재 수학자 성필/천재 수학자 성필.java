import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		Stack<Integer> operand = new Stack<Integer>(); 
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (c >= '0' && c <= '9') {
				operand.push(c - '0');
				
			} else if (c == '*') {
				operand.push(operand.pop() * operand.pop());
				
			} else if (c == '/') {
				int temp = operand.pop();
				operand.push(operand.pop() / temp);
				
			} else if (c == '+'){
				operand.push(operand.pop() + operand.pop());
				
			} else {
				int temp = operand.pop();
				operand.push(operand.pop() - temp);
			}
		}
		
		System.out.println(operand.pop());
		
		br.close();
	}
}