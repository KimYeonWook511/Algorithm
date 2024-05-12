import java.io.*;
import java.util.*;

public class Main {
	static int N, K, arr[], result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0, 0, 500);

		System.out.println(result);

		br.close();
	}

	static void func(int cnt, int bit, int val) {
		if (cnt == N) {
			result++;

			return;
		}

		for (int i = 0; i < N; i++) {
			if (((1 << i) & bit) != 0) continue;
			if (val - K + arr[i] < 500) continue;

			func(cnt + 1, bit | (1 << i), val - K + arr[i]);
		}
	}
}