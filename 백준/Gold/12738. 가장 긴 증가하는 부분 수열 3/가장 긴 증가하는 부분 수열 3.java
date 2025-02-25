import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int arr[] = new int[N];
		int idx = -1;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			int left = 0;
			int right = idx;

			while (left <= right) {
				int mid = (left + right) >> 1;

				if (arr[mid] >= num) right = mid - 1;
				else left = mid + 1;
			}

			arr[left] = num;

			if (left > idx) idx++;
		}

		System.out.println(idx + 1);

        br.close();
    }
}