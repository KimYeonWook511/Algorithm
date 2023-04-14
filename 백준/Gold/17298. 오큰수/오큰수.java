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
		int arr[] = new int[n];
		int result[] = new int[n];
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.push(0);
		
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[stack.peek()]) {
				while (!stack.empty()) {
					if (arr[i] <= arr[stack.peek()]) break;
					
					result[stack.pop()] = arr[i];
				}
			}
			
			stack.push(i);
		}
		
		for (int i = 0; i < n; i++) {
			int num = result[i];
			
			bw.write(num == 0 ? "-1 " : num + " ");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}
