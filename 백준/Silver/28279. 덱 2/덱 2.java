import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Deque<String> deque = new ArrayDeque<String>();
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if (cmd.equals("1")) deque.offerFirst(st.nextToken());
			else if (cmd.equals("2")) deque.offerLast(st.nextToken());
			else if (cmd.equals("5")) sb.append(deque.size()).append("\n");
			else if (cmd.equals("6")) sb.append(deque.isEmpty() ? "1\n" : "0\n");
			else if (deque.isEmpty()) sb.append("-1\n");
			else if (cmd.equals("3")) sb.append(deque.pollFirst()).append("\n");
			else if (cmd.equals("4")) sb.append(deque.pollLast()).append("\n");
			else if (cmd.equals("7")) sb.append(deque.peekFirst()).append("\n");
			else sb.append(deque.peekLast()).append("\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}