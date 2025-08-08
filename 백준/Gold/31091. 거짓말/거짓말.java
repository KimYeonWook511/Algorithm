import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int left[] = new int[N + 1]; // 진실에서 거짓으로
		int right[] = new int[N + 1]; // 거짓에서 진실로
		int cnt = 0; // 거짓말을 하고 있는 사람 수

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(st.nextToken());

			if (k <= 0) left[-k]++;
			else {
				right[k]++;
				cnt++;
			}
		}

		int result = 0;
		for (int i = 0; i <= N; i++) {
			cnt -= right[i]; // 거짓이던 사람이 진실이 됨

			if (cnt == i) {
				result++;
				sb.append(i).append(" ");
			}

			cnt += left[i]; // 진실이던 사람이 거짓이 됨
		}

		System.out.println(result);
		System.out.println(sb);

		br.close();
	}
}
