import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken(); // N
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int arr[] = new int[K];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = arr[K - 1] - arr[0];
		while (left <= right) {
			int mid = (left + right) >> 1;

			int cnt = 1;
			int pre = arr[0];
			for (int i = 1; i < K; i++) {
				if (arr[i] - pre < mid) continue;

				cnt++;
				pre = arr[i];
			}

			if (cnt >= M) left = mid + 1;
			else right = mid - 1;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("1");
		int pre = arr[0];
		M--;
		for (int i = 1; i < K; i++) {
			if (M == 0 || arr[i] - pre < right) {
				sb.append("0");
			} else {
				sb.append("1");
				pre = arr[i];
				M--;
			}
		}

		System.out.println(sb);

		br.close();
	}
}