import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		boolean sort[] = new boolean[N + 1];
		int deque[] = new int[(Q << 1) + 1];
		int left = Q - 1; // rev
		int right = Q + 1;
		boolean rev = false;
		
		for (int run = 0; run < Q; run++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			
			if (cmd == 0) {
				if (rev) deque[left--] = Integer.parseInt(st.nextToken());
				else deque[right++] = Integer.parseInt(st.nextToken());
				
			} else if (cmd == 2) {
				rev = !rev;
				
			} else {
				for (int i = Q + 1; i < right; i++) {
					sort[deque[i]] = true;
				}
				
				for (int i = Q - 1; i > left; i--) {
					sort[deque[i]] = true;
				}
				
				left = Q - 1;
				right = Q + 1;
				rev = false;
			}
		}
		
		int result = 0;
		
		if (rev) {
			k -= Q - left - 1;
			
			if (k <= 0) result = deque[Q + k - 1];
			else {
				for (int i = N; i > 0; i--) {
					if (sort[i] && --k == 0) {
						result = i;
						break;
					}
				}
				
				if (k > 0) result = deque[Q + k];
			}
			
			
		} else {
			k -= right - Q - 1;
			
			if (k <= 0) result = deque[Q - k + 1];
			else {
				for (int i = 1; i <= N; i++) {
					if (sort[i] && --k == 0) {
						result = i;
						break;
					}
				}
				
				if (k > 0) result = deque[Q - k];
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}