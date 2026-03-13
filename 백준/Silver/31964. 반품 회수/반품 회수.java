import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int X[] = new int[N];
		int T[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			T[i] = Integer.parseInt(st.nextToken());
		}

		long ans = 2L * X[N - 1];
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, T[i] + X[i]);
		}

		System.out.println(ans);

		br.close();
	}
}