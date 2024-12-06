import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int l = 0;
		int r = N - 1;

		int result = Integer.MAX_VALUE;
		while (l < r) {
			int val = arr[l] + arr[r];

			if (val == 0) {
				result = 0;
				break;
			} 

			if (Math.abs(val) < Math.abs(result)) result = val;

			if (val < 0) l++;
			else r--;
		}

		System.out.println(result);

		br.close();
	}
}