import java.io.*;
import java.util.*;

public class Main {
	
	static int N, arr[][], min = Integer.MAX_VALUE, start;
	static boolean chk[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		chk = new boolean[N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (; start < N; start++) {
			func(0, start, 0);
		}
		
		System.out.println(min);
		
		br.close();
	}
	
	static void func(int cnt, int pre, int sum) {
		if (sum > min) return;
		
		if (cnt == N - 1) {
			if (arr[pre][start] != 0) min = Math.min(min, sum + arr[pre][start]);
			
			return;
		}
		
		chk[pre] = true;
		for (int next = 0; next < N; next++) {
			if (chk[next]) continue;
			if (arr[pre][next] == 0) continue;
			
			func(cnt + 1, next, sum + arr[pre][next]);
		}
		chk[pre] = false;
	}
}