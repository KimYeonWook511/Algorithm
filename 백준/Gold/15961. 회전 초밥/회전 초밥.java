import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
		int cnt[] = new int[d + 1];
		int result = 0;
		
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			if (cnt[arr[i]] == 0) result++;
			
			cnt[arr[i]]++;
		}
		
		int max = cnt[c] == 0 ? result + 1 : result;
		
		for (int i = k; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			// 이전 초밥 빼기
			cnt[arr[i - k]]--;
			if (cnt[arr[i - k]] == 0) result--;
			
			// 현재 초밥 더하기
			if (cnt[arr[i]] == 0) result++;
			cnt[arr[i]]++;
			
			max = Math.max(max, cnt[c] == 0 ? result + 1 : result);
		}
		
		
		for (int i = 0; i < k - 1; i++) {
			// 이전 초밥 빼기
			cnt[arr[N - k + i]]--;
			if (cnt[arr[N - k + i]] == 0) result--;
			
			// 현재 초밥 더하기
			if (cnt[arr[i]] == 0) result++;
			cnt[arr[i]]++;
			
			max = Math.max(max, cnt[c] == 0 ? result + 1 : result);
		}
		
		System.out.println(max);
		
		br.close();
	}
}