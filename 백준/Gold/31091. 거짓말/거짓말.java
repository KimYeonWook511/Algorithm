import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int cnt[] = new int[N + 2];
		int liarCnt = 0; // 거짓말을 하고 있는 사람 수

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(st.nextToken());

			if (k <= 0) cnt[-k + 1]++;
			else {
				cnt[k]--;
				liarCnt++;
			}
		}

		int result = 0;
		for (int i = 0; i <= N; i++) {
			liarCnt += cnt[i];

			if (liarCnt == i) {
				result++;
				sb.append(i).append(" ");
			}
		}

		System.out.println(result);
		System.out.println(sb);

		br.close();
	}
}
