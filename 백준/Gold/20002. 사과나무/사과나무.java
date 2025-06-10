import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int sum[][] = new int[N + 1][N + 1];

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 1; c <= N; c++) {
				sum[r][c] = sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1] + Integer.parseInt(st.nextToken());
			}
		}

		int result = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int r = 1; r < N - i + 1; r++) {
				for (int c = 1; c < N - i + 1; c++) {
					result = Math.max(result, sum[r + i][c + i] - sum[r - 1][c + i] - sum[r + i][c - 1] + sum[r - 1][c - 1]);
				}
			}
		}

		System.out.println(result);

        br.close();
    }
}