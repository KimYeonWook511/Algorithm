import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long arr[] = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);

		long max = arr[N - 1];

		if (N % 2 == 0) {
			for (int i = (N >> 1) - 1; i >= 0; i--) {
				long val = arr[i] + arr[N - 1 - i];

				max = Math.max(max, val);
			}

		} else {
			for (int i = (N >> 1) - 1; i >= 0; i--) {
				long val = arr[i] + arr[N - 2 - i];

				max = Math.max(max, val);
			}
		}

		System.out.println(max);

		br.close();
	}
}