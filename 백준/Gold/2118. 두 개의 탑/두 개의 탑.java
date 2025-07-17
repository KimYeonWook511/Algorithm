import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N + 1];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		int start = 0;
		int end = 0;
		int val = arr[0];
		int result = 0;
		
		while (start <= end) {
			if (end == N) break;
			
			int min = Math.min(val, sum - val);
			
			if (val == min) {
				end++;
				val += arr[end];
				
			} else {
				val -= arr[start];
				start++;
			}
			
			result = Math.max(result, min);
		}
		
		System.out.println(result);
		
		br.close();
	}
}