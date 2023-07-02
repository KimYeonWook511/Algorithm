import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine()); 
		Queue<Integer> queue = new LinkedList<Integer>();
		int back = 0;
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if (cmd.equals("push")) {
				back = Integer.parseInt(st.nextToken());
				queue.offer(back);
				
			} else if (cmd.equals("pop")) {
				bw.write(queue.isEmpty() ? "-1\n" : queue.poll() + "\n");
				
			} else if (cmd.equals("size")) {
				bw.write(queue.size() + "\n");
				
			} else if (cmd.equals("empty")) {
				bw.write(queue.isEmpty() ? "1\n" : "0\n"); 
				
			} else if (cmd.equals("front")) {
				bw.write(queue.isEmpty() ? "-1\n" : queue.peek() + "\n");
				
			} else {
				bw.write(queue.isEmpty() ? "-1\n" : back + "\n");
			}
		}
		
		br.close();
		bw.close();
	}
}