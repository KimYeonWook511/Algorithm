import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int g = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int val = l / g;

		long result1 = 0;
		long result2 = 0;

		for (int i = 1; i * i <= val; i++) {
			if (val % i != 0) continue;
			if (func(i, val / i) != 1) continue;

			result1 = i * g;
			result2 = val / i * g;
		}

		System.out.println(result1 + " " + result2);

		br.close();
	}

	static long func(int a, int b) {
		if (b == 0) return a;

		return func(b, a % b);
	}
}