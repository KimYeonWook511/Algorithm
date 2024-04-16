import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int result[] = new int[N];
		int idx = -1;
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			int right = idx;
			int left = 0;
			
			while (left <= right) {
				int mid = (left + right) >> 1;
				int val = result[mid];
			
				if (val >= num) right = mid - 1;
				else left = mid + 1;
			}
			
			result[left] = num;
			
			if (left > idx) idx++;
		}

		System.out.println(idx + 1);
		
		br.close();
	}
}