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
		int arr[] = new int[n];
		int result[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		long cnt = 0;
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		stack.push(0);
		
		for (int i = 1; i < n; i++) {
			while (!stack.empty() && arr[i] >= arr[stack.peek()]) {
				int idx = stack.pop();
				
				if (!stack.empty()) result[stack.peek()] += result[idx] + 1;
			}
			
			stack.push(i); 
		}
		
		while (!stack.empty()) {
			int idx = stack.pop();
			
			if (!stack.empty()) result[stack.peek()] += result[idx] + 1;
		}
		
		for (int i = 0; i < n; i++) {
			cnt += result[i];
		}
		
		bw.write(Long.toString(cnt));
		
		br.close();
		bw.close();
	}
}