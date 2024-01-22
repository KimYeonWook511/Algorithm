import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, N, M, K, cnt;
	static boolean arr[][], chk[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new boolean[N][M];
			chk = new boolean[N][M];
			cnt = 0;
			
			for (int run = 0; run < K; run++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				arr[r][c] = true;
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (chk[r][c]) continue;
					
					if (arr[r][c]) {
						func(r, c);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	static void func(int r, int c) {
		if (r < 0 || c < 0) return;
		if (r >= N || c >= M) return;
		if (chk[r][c]) return;
		if (!arr[r][c]) return;
		
		chk[r][c] = true;
		
		func(r - 1, c);
		func(r + 1, c);
		func(r, c - 1);
		func(r, c + 1);
	}
}