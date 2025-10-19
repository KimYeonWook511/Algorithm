import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int arr[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int o1[], int o2[]) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		int answer = 0;
		int sum = 0;
		// 학교 좌측 셔틀
		for (int i = 0; i < N; i++) {
			if (arr[i][0] > S) {
				sum = 0;
				break;
			}

            if (sum == 0) {
                // arr[i][0]에서 부터 사람 탔음
                answer += 2 * (S - arr[i][0]);
            }
			sum += arr[i][1];

			if (sum >= K) {
                answer += (2 * (S - arr[i][0])) * ((sum - 1) / K);
                sum %= K;
			}
		}

		// 학교 우측 셔틀
		for (int i = N - 1; i >= 0; i--) {
			if (arr[i][0] < S) {
				sum = 0;
				break;
			}

            if (sum == 0) {
                // arr[i][0]에서 부터 사람 탔음
                answer += 2 * (arr[i][0] - S);
            }
            sum += arr[i][1];

            if (sum >= K) {
                answer += (2 * (arr[i][0] - S)) * ((sum - 1) / K);
                sum %= K;
            }
		}

        System.out.println(answer);

		br.close();
	}
}