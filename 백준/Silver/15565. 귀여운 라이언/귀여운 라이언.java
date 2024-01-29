import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int min = 1_000_001;
		Deque<Integer> deque = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			if (st.nextToken().equals("1")) deque.offerLast(i);
			
			if (deque.size() == K) min = Math.min(min, i - deque.pollFirst() + 1);
		}
		
		System.out.println(min == 1_000_001 ? -1 : min);
		
		br.close();
	}
}