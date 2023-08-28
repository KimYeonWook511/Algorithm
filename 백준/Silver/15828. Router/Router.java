import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		
		while (true) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == -1) break;
			else if (num == 0) queue.poll();
			else if (queue.size() < n) queue.offer(num);
		}
		
		if (queue.size() == 0) {
			bw.write("empty");
			
		} else {
			while (!queue.isEmpty()) {
				bw.write(queue.poll() + " ");
			}
		}
		
		br.close();
		bw.close();
	}
}