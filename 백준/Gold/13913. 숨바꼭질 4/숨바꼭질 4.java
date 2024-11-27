import java.io.*;
import java.util.*;

public class Main {
	static class Val {
		int i, t;

		Val (int i, int t) {
			this.i = i;
			this.t = t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int chk[] = new int[100_001];
		for (int i = 0; i <= 100_000; i++) {
			chk[i] = -1;
		}

		Deque<Val> deque = new ArrayDeque<>();
		deque.offer(new Val(N, 0));
		chk[N] = N;

		Val cur;
		int result[];
		while (!deque.isEmpty()) {
			cur = deque.poll();

			if (cur.i == K) {
				result = new int[cur.t + 1];
				int num = cur.i;

				for (int idx = cur.t; idx >= 0; idx--) {
					result[idx] = num;
					num = chk[num];
				}

				sb.append(cur.t).append("\n");

				for (int i = 0; i <= cur.t; i++) {
					sb.append(result[i]).append(" ");
				}

				break;
			}

			if (cur.i > 0 && chk[cur.i - 1] == -1) {
				deque.offer(new Val(cur.i - 1, cur.t + 1));
				chk[cur.i - 1] = cur.i;
			}

			if (cur.i <= K && chk[cur.i + 1] == -1) {
				deque.offer(new Val(cur.i + 1, cur.t + 1));
				chk[cur.i + 1] = cur.i;
			}

			if (((cur.i - 1) << 1) < K && chk[cur.i << 1] == -1) {
				deque.offer(new Val(cur.i << 1, cur.t + 1));
				chk[cur.i << 1] = cur.i;
			}
		}

		System.out.println(sb);
		
		br.close();
	}
}