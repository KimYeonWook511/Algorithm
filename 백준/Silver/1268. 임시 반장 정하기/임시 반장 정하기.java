import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][5];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int k = 0; k < 5; k++) {
				arr[i][k] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0;
		int result = 0;
		for (int i = 0; i < N; i++) {
			boolean chk[] = new boolean[N];
			int cnt = 0;

			for (int k = 0; k < N; k++) {
				if (i == k) continue;

				for (int p = 0; p < 5; p++) {
					if (arr[i][p] != arr[k][p]) continue;
					if (chk[k]) continue;

					chk[k] = true;
					cnt++;
				}
			}

			if (cnt > max) {
				max = cnt;
				result = i;
			}
		}
		
		System.out.println(result + 1);

		br.close();
	}
}