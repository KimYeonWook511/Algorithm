import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken(); // H
		int W = Integer.parseInt(st.nextToken());

		int arr[] = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = W - 1;
		int leftMax = 0;
		int rightMax = 0;
		int result = 0;
		while (left <= right) {
			if (arr[left] <= arr[right]) {
				if (arr[left] < leftMax) result += leftMax - arr[left];
				else leftMax = arr[left];
				left++;
			} else {
				if (arr[right] < rightMax) result += rightMax - arr[right];
				else rightMax = arr[right];
				right--;
			}
		}

		System.out.println(result);

		br.close();
	}
}
