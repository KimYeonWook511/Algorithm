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
		
		int t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			Integer.parseInt(br.readLine()); // n
			
			st = new StringTokenizer(br.readLine());
			Deque<Character> deq = new ArrayDeque<>();
			deq.offer(st.nextToken().charAt(0));
			
			while (st.hasMoreTokens()) {
				char c = st.nextToken().charAt(0);
				
				if (c <= deq.peekFirst()) deq.offerFirst(c);
				else deq.offerLast(c);
			}
			
			while (!deq.isEmpty()) {
				sb.append(deq.pollFirst());
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}
