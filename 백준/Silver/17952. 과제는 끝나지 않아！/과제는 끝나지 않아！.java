import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int at[][] = new int[n][2];
		Stack<Integer> stack = new Stack<>();
		int score = 0;
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			
			if (Integer.parseInt(st.nextToken()) == 1) {
				at[run][0] = Integer.parseInt(st.nextToken());
				at[run][1] = Integer.parseInt(st.nextToken()) - 1;
				
				stack.push(run);
				
			} else if (!stack.empty()) {
				at[stack.peek()][1]--;
			}
			
			if (!stack.empty() && at[stack.peek()][1] == 0) score += at[stack.pop()][0];
		}
		
		System.out.println(score);
		
		br.close();
	}
}