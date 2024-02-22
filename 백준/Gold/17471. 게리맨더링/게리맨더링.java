import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, people[], min = Integer.MAX_VALUE;
	static boolean graph[][];
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		
		people = new int[N + 1];
		graph = new boolean[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int len = Integer.parseInt(st.nextToken());
			
			for (int run = 0; run < len; run++) {
				graph[i][Integer.parseInt(st.nextToken())] = true;
			}
		}

		for (int i = 1; i <= N; i++) {
			func(1, i + 1, 1 << i);
		}
		
		System.out.println(min == Integer.MAX_VALUE ? "-1" : min);
		
		br.close();
	}
	
	static void func(int cnt, int startIdx, int selectBit) {
		if (cnt > (N >> 1)) return;
		
		int sumA = bfs(selectBit);
		int sumB = bfs((((1 << N + 1) - 1) & ~selectBit) - 1); 

		if (sumA > 0 && sumB > 0) min = Math.min(min, Math.abs(sumA - sumB));

		for (int i = startIdx; i <= N; i++) {
			if ((selectBit & (1 << i)) != 0) continue;
			
			func(cnt + 1, i + 1, selectBit | (1 << i));
		}
	}
	
	static int bfs(int selectBit) {
		Deque<Integer> deque = new ArrayDeque<>();
		
		int sum = 0;

		for (int i = 1; i <= N; i++) {
			if ((selectBit & (1 << i)) != 0) {
				deque.offerLast(i);
				selectBit &= ~(1 << i);
				sum += people[i];

				while (!deque.isEmpty()) {
					int cur = deque.pollFirst();
					
					for (int k = 1; k <= N; k++) {
						if (!graph[cur][k]) continue;
						if ((selectBit & (1 << k)) == 0) continue;
						
						selectBit &= ~(1 << k);
						sum += people[k];
						deque.offerLast(k);
					}
				}

				break;
			}
		}

		if (selectBit == 0) return sum;

		return 0;
	}
}