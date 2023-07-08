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
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		int arr[] = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			deque.offer(i);
		}
		
		while (deque.size() > 1) {
			int idx = deque.pollFirst();
			
			bw.write(idx + " ");
			
			int p = arr[idx];
			
			for (int i = 1; i < p; i++) {
				deque.offerLast(deque.pollFirst());
			}
			
			for (int i = 0; i > p; i--) {
				deque.offerFirst(deque.pollLast());
			}
		}
		
		bw.write(Integer.toString(deque.poll()));
		
		br.close();
		bw.close();
	}
}
