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
		String prefix = br.readLine();
		double v[] = new double[n]; // 0 : 'A' ~~ 25 : 'Z'
		
		for (int i = 0; i < n; i++) {
			v[i] = Double.parseDouble(br.readLine());
		}
		
		Stack<Double> stack = new Stack<>();
		
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			double temp = 0;
			
			switch (c) {
			case '+':
				stack.push(stack.pop() + stack.pop());
				break;
			case '-':
				temp = stack.pop();
				stack.push(stack.pop() - temp);
				break;
			case '*':
				stack.push(stack.pop() * stack.pop());
				break;
			case '/':
				temp = stack.pop();
				stack.push(stack.pop() / temp);
				break;
			default:
				stack.push(v[c - 'A']);
			}
		}
		
		bw.write(String.format("%.2f", stack.pop()));
		
		br.close();
		bw.close();
	}
}