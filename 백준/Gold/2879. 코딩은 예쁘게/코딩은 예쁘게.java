import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int arr[] = new int[N];

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken()) - Integer.parseInt(st2.nextToken());
		}

		int idx = -1;
		int cnt = 0;
		int temp = 0;

		while (++idx < N) {
			if (arr[idx] == 0) {
				cnt += Math.abs(temp);
				temp = 0;
				continue;
			}

			if (arr[idx] < 0) {
				if (temp > 0) {
					cnt += temp;
					temp = arr[idx];
					continue;
				}

				if (arr[idx] <= temp) {
					temp = arr[idx];
					continue;
				} 

				cnt -= temp;
				temp = arr[idx];

				for (int i = idx; i < N; i++) {
					if (arr[i] >= 0) break;

					temp = Math.max(temp, arr[i]);
					arr[i] -= temp;
				}

				temp = 0;

			} else {
				if (temp < 0) {
					cnt -= temp;
					temp = arr[idx];
					continue;
				}

				if (arr[idx] >= temp) {
					temp = arr[idx];
					continue;
				} 

				cnt += temp;
				temp = arr[idx];
				
				for (int i = idx; i < N; i++) {
					if (arr[i] <= 0) break;

					temp = Math.min(temp, arr[i]);
					arr[i] -= temp;
				}

				temp = 0;
			}
		}

		System.out.println(cnt + Math.abs(temp));

		br.close();
	}
}