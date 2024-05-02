import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long arr[] = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);
		long result[] = new long[3];
		long absMin = Long.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			int left = i + 1;
			int right = N - 1;
			long sum = 0;
			long absVal = 0;
			
			while (left < right) {
				sum = arr[i] + arr[left] + arr[right];
				absVal = Math.abs(sum);
				
				if (absVal < absMin) {
					absMin = absVal;
					result[0] = arr[i];
					result[1] = arr[left];
					result[2] = arr[right];
				}
				
				if (sum < 0) left++;
				else if (sum > 0) right--;
				else break;
			}
			
			if (absMin == 0) break;
		}
			
		sb.append(result[0]).append(" ").append(result[1]).append(" ").append(result[2]);
		System.out.println(sb);
		
		br.close();
	}
}