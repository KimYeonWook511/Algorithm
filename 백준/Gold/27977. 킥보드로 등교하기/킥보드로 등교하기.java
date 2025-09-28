import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int A[] = new int[N + 2];
		A[N + 1] = L;

		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, A[i] - A[i - 1]);
		}
		max = Math.max(max, A[N + 1] - A[N]);

		int left = max;
		int right = L;
		while (left <= right) {
			int mid = (left + right) >> 1;

			int sum = 0;
			int cnt = 0;
			for (int i = 1; i < A.length; i++) {
				int dist = A[i] - A[i - 1];

				if (sum + dist <= mid) {
					sum += dist;
					continue;
				}

				if (++cnt > K) break;
				sum = dist;
			}

			if (cnt <= K) right = mid - 1;
			else left = mid + 1;
		}

		System.out.println(left);

        br.close();
    }
}