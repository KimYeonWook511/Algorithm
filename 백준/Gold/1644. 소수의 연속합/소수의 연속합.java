import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());

		boolean prime[] = new boolean[N + 1]; // false : isPrime
		int sum[] = new int[N + 1]; // prime sum
		int idx = 1;
		prime[0] = true;
		prime[1] = true;

		int end = (int)Math.sqrt(N);

		for (int i = 2; i <= end; i++) {
			if (prime[i]) continue;

			for (int k = i * i; k <= N; k += i) {
				prime[k] = true;
			}
		}

		for (int i = 2; i <= N; i++) {
			if (prime[i]) continue;

			sum[idx] = sum[idx - 1] + i;
			idx++;
		}

		int left = 0;
		int right = 0;
		int cnt = 0;

		while (right < idx) {
			int val = sum[right] - sum[left];

			if (val < N) right++;
			else if (val > N) left++;
			else {
				right++;
				left++;
				cnt++;
			}
		}

		System.out.println(cnt);

		br.close();
	}
}