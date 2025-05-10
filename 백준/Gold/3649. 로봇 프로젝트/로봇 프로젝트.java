import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = "";
		while (true) {
			input = br.readLine();

			if (input == null) break;

			int x = Integer.parseInt(input) * 10_000_000;
			int n = Integer.parseInt(br.readLine());

			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}

			Arrays.sort(arr);

			int l = 0;
			int r = n - 1;
			while (l < r) {
				int sum = arr[l] + arr[r];

				if (sum == x) break;

				if (sum < x) l++;
				else r--;
			}

			sb.append(l >= r ? "danger\n" : String.format("yes %d %d\n", arr[l], arr[r]));
		}
		
		System.out.println(sb);

		br.close();
	}
}