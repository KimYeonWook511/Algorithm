import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		long left = 0;
		long right = Integer.MAX_VALUE;
		while (left <= right) {
			long mid = (left + right) >> 1;
		
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if (mid < arr[i]) continue;
				
				sum += mid - arr[i];
			}
			
			if (sum > K) right = mid - 1;
			else left = mid + 1;
		}
		
		System.out.println(right);
		
		br.close();
	}
}