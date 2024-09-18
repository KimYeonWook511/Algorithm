import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		boolean isNotPrime[] = new boolean[B + 1];
		isNotPrime[0] = isNotPrime[1] = true;

		for (int i = 2; i * i <= B; i++) {
			if (isNotPrime[i]) continue;

			for (int k = i * i; k <= B; k += i) {
				isNotPrime[k] = true;
			}
		}

		int result = 0;
		while (A <= B) {
			int cnt = 0;
			int num = A;

			for (int i = 2; i * i <= A; i++) {
				if (isNotPrime[i]) continue;

				while (num % i == 0) {
					cnt++;
					num /= i;
				}
			}

			if (!isNotPrime[cnt + (num > 1 ? 1 : 0)]) result++;

			A++;
		}

		System.out.println(result);

		br.close();
	}
}