import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author 김연욱 
 * @date 24.01.31
 * @link https://www.acmicpc.net/problem/11660
 * @keyword_solution (x1, y1)부터 (x2, y2)까지 합
 * @input
 * - 1 ≤ N ≤ 1,024
 * - 1 ≤ M ≤ 100,000
 * - x1 ≤ x2, y1 ≤ y2
 * @output
 * - 1,024 * 1,024 * 1,000 = 1,048,576,000
 * @time_complex O(N^2 + M) -> O(N^2)
 * @perf 117976KB | 836ms
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N, M, arr[][];
	static int x1, y1, x2, y2;

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 1; c <= N; c++) {
				arr[r][c] = arr[r - 1][c] + arr[r][c - 1] - arr[r - 1][c - 1] + Integer.parseInt(st.nextToken());
			}
		}

		for (int run = 0; run < M; run++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			sb.append(arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1]).append("\n");
		}

		System.out.println(sb);

		br.close();
	}
}