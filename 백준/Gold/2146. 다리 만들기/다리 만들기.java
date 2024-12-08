import java.io.*;
import java.util.*;

public class Main {
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < N; c++) {
				if (st.nextToken().charAt(0) == '0') continue;

				arr[r][c] = -1;
			}
		}

		Deque<int[]> deque = new ArrayDeque<>();
		int cur[];
		int nr, nc;

		int num = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (arr[r][c] != -1) continue;

				arr[r][c] = num;
				deque.offer(new int[]{r, c});

				while (!deque.isEmpty()) {
					cur = deque.poll();

					for (int d = 0; d < 4; d++) {
						nr = cur[0] + dr[d];
						nc = cur[1] + dc[d];

						if (nr < 0 || nc < 0) continue;
						if (nr >= N || nc >= N) continue;
						if (arr[nr][nc] != -1) continue;

						arr[nr][nc] = num;
						deque.offer(new int[]{nr, nc});
					}
				}

				num++;
			}
		}

		PriorityQueue<int[]> pq;
		boolean chk[][];
		int result = Integer.MAX_VALUE;
		
		num = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (arr[r][c] != num) continue;

				pq = new PriorityQueue<>(new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						return Integer.compare(o1[2], o2[2]);
					}
				});
				chk = new boolean[N][N];

				pq.offer(new int[]{r, c, 0});
				chk[r][c] = true;

				while (!pq.isEmpty()) {
					cur = pq.poll();

					if (arr[cur[0]][cur[1]] != 0 && arr[cur[0]][cur[1]] != num) {
						result = Math.min(result, cur[2] - 1);
						break;
					}

					for (int d = 0; d < 4; d++) {
						nr = cur[0] + dr[d];
						nc = cur[1] + dc[d];

						if (nr < 0 || nc < 0) continue;
						if (nr >= N || nc >= N) continue;
						if (chk[nr][nc]) continue;

						chk[nr][nc] = true;

						if (arr[nr][nc] == num) pq.offer(new int[]{nr, nc, 0});
						else pq.offer(new int[]{nr, nc, cur[2] + 1});
					}
				}

				num++;
			}
		}

		System.out.println(result);

		br.close();
	}
}