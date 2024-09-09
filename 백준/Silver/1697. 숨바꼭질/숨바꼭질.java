import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Deque<int[]> deque = new ArrayDeque<>();
		boolean chk[] = new boolean[100_001];

		deque.offer(new int[] { N, 0 });
		chk[N] = true;

		while (!deque.isEmpty()) {
			int cur[] = deque.poll();

			if (cur[0] == K) {
				System.out.println(cur[1]);
				break;
			}

			if (cur[0] - 1 >= 0 && !chk[cur[0] - 1]) {
				deque.offer(new int[] { cur[0] - 1, cur[1] + 1 });
				chk[cur[0] - 1] = true;
			}

			if (cur[0] + 1 <= 100_000 && !chk[cur[0] + 1]) {
				deque.offer(new int[] { cur[0] + 1, cur[1] + 1 });
				chk[cur[0] + 1] = true;
			}

			if ((cur[0] << 1) <= 100_000 && !chk[cur[0] << 1]) {
				deque.offer(new int[] { cur[0] << 1, cur[1] + 1 });
				chk[cur[0] << 1] = true;
			}
		}

		br.close();
	}
}