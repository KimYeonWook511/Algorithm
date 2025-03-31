import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int arr[] = new int[n];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(arr);

            int left = 0;
            int right = n - 1;
            int min = Integer.MAX_VALUE;
            int cnt = 0;
            
            while (left < right) {
            	int val = arr[left] + arr[right];
            	int absVal = Math.abs(val - K);

				if (val < K) left++;
				else right--; 
				
				if (absVal > min) continue;
				
				if (absVal < min) cnt = 0;
				
				min = absVal;
				cnt++;
            }
            
            sb.append(cnt).append('\n');
			
		}
		
		System.out.println(sb);
		
		br.close();
	}
}