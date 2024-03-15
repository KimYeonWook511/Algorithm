import java.io.*;
import java.util.*;

public class Main {
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean arr[][] = new boolean[n + 2][m + 2];
		for (int r = 1; r <= n; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 1; c <= m; c++) {
				if (st.nextToken().charAt(0) == '1') arr[r][c] = true;
			}
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -Integer.compare(o1, o2);
			}
		});
		pq.offer(0);
		int cnt = 0;

		Deque<int[]> deque = new ArrayDeque<>();

		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= m; c++) {
				if (!arr[r][c]) continue;

				arr[r][c] = false;
				deque.offer(new int[]{r, c});

				int size = 0;

				while (!deque.isEmpty()) {
					int cur[] = deque.poll();
					size++;

					int nr, nc;
					for (int i = 0; i < 4; i++) {
						nr = cur[0] + dr[i];
						nc = cur[1] + dc[i];

						if (!arr[nr][nc]) continue;

						arr[nr][nc] = false;
						deque.offer(new int[]{nr, nc});
					}
				}

				pq.offer(size);
				cnt++;
			}
		}

		sb.append(cnt).append("\n").append(pq.poll());

		System.out.println(sb);

        br.close();
    }
}