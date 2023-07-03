import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		
		while (queue.size() > 1) {
			bw.write(queue.poll() + " ");
			
			queue.offer(queue.poll());
		}
		
		bw.write(queue.poll() + "");
		
		br.close();
		bw.close();
	}
}