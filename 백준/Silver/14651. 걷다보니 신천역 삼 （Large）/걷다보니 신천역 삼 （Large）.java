import java.io.*;

public class Main {
	static final long MOD = 1_000_000_009; // int로 하면 어차피 자동 캐스팅 됨

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long answer = 0;
		if (N > 1) {
			answer = 2;
			for (int i = 2; i < N; i++) {
				answer = (3 * answer) % MOD;
			}
		}

		System.out.println(answer);

		br.close();
	}
}