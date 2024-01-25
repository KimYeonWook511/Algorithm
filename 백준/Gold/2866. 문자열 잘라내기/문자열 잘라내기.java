import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char arr[][] = new char[R][C];
		
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			
			for (int c = 0; c < C; c++) {
				arr[r][c] = str.charAt(c);
			}
		}
		
		String str[] = new String[C];
		StringBuilder sb;
		
		for (int c = 0; c < C; c++) {
			sb = new StringBuilder();
			
			for (int r = 1; r < R; r++) {
				sb.append(arr[r][c]);
			}
			
			str[c] = sb.toString();
		}
		
		int left = 0;
		int right = R;
		
		while (left <= right) {
			Set<String> set = new HashSet<>();
			int mid = (left + right) / 2;
			boolean flag = false;
			
			for (int i = 0; i < C; i++) {
				if (!set.add(str[i].substring(mid))) {
					flag = true;
					break;
				}
			}
			
			if (flag) right = mid - 1;
			else left = mid + 1;
		}
		
		System.out.println(left);
		
		br.close();
	}
}