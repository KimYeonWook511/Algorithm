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
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Integer.parseInt(st.nextToken()); // p
		
		Stack<Integer> stack[] = new Stack[7];
		int cnt = 0;
		
		for (int i = 0; i < 7; i++) {
			stack[i] = new Stack<>();
		}
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			
			while (!stack[n1].empty() && stack[n1].peek() > p1) {
				stack[n1].pop();
				cnt++;
			}
			
			if (stack[n1].empty() || stack[n1].peek() != p1) {
				stack[n1].push(p1);
				cnt++;
			}
		}
		
		bw.write(Integer.toString(cnt));
		
		br.close();
		bw.close();
	}
}