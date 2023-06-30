import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;		
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>(); 
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if (cmd.equals("push_front")) {
				deque.addFirst(Integer.parseInt(st.nextToken()));
				
			} else if (cmd.equals("push_back")) {
				deque.addLast(Integer.parseInt(st.nextToken()));
				
			} else if (cmd.equals("pop_front")) {
				bw.write(deque.isEmpty() ? "-1\n" : deque.pollFirst() + "\n");
				
			} else if (cmd.equals("pop_back")) {
				bw.write(deque.isEmpty() ? "-1\n" : deque.pollLast() + "\n");
				
			} else if (cmd.equals("size")) {
				bw.write(deque.size() + "\n");
				
			} else if (cmd.equals("empty")) {
				bw.write(deque.isEmpty() ? "1\n" : "0\n");
				
			} else if (cmd.equals("front")) {
				bw.write(deque.isEmpty() ? "-1\n" : deque.peekFirst() + "\n");
				
			} else {
				// back
				bw.write(deque.isEmpty() ? "-1\n" : deque.peekLast() + "\n");
			}
		}
		
		br.close();
		bw.close();
	}
}