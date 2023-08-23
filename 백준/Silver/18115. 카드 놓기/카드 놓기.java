import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n + 1];
		
		for (int i = n; i > 0; i--) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		for (int i = 1; i <= n; i++) {
			int skill = arr[i];
			
			if (skill == 1) {
				deque.offerFirst(i);
				
			} else if (skill == 2) {
				Integer temp = deque.pollFirst();
				deque.offerFirst(i);
				
				if (temp != null) deque.offerFirst(temp);
				
			} else {
				deque.offerLast(i);
			}
		}
		
		while (!deque.isEmpty()) {
			bw.write(deque.pollFirst() + " ");
		}
		
		br.close();
		bw.close();
	}
}
