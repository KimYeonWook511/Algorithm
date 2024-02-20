import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, A, B, cnt[];
	static List<Integer> graph[];
	static Deque<Integer> deque = new ArrayDeque<>(); 
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		cnt = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int run = 0; run < M; run++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
			cnt[B]++;
		}
		
		for (int i = 1; i <= N; i++) {
			if (cnt[i] == 0) deque.offerLast(i);
		}
		
		while (!deque.isEmpty()) {
			A = deque.pollFirst();
			
			sb.append(A).append(" ");
			
			for (int B : graph[A]) {
				cnt[B]--;
				
				if (cnt[B] == 0) deque.offerLast(B);
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}
}