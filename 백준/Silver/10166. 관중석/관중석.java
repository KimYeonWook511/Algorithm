import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D1 = Integer.parseInt(st.nextToken());
		int D2 = Integer.parseInt(st.nextToken());

		long result = 0;
		boolean chk[][] = new boolean[D2 + 1][D2 + 1];
		for (int i = D1; i <= D2; i++) {
			for (int k = 1; k <= i; k++) {
				int val = func(i, k);
				int r = i / val;
				int c = k / val;

				if (chk[r][c]) continue;

				chk[r][c] = true;
				result++;
			}
		}

		System.out.println(result);

		br.close();
	}

	static int func(int a, int b) {
		return b == 0 ? a : func(b, a % b);
	}
}