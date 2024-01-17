import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T, arr[][][], sum, val, now, next;
	static int A[] = new int[2];
	static boolean isBottom;
	static int move[][][] = {{{-1, 0}, {0, 1}, {1, 0}, {0, -1}},
							{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		arr = new int[2][R][C];
		
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < C; c++) {
				arr[0][r][c] = Integer.parseInt(st.nextToken());
				
 				if (arr[0][r][c] == -1) {
 					if (isBottom) {
 						A[1] = r;
 						arr[1][r][c] = -1;
 						
 					} else {
 						A[0] = r;
 						arr[0][r][c] = -1;
 						isBottom = true;
 					}
 				}
			}
		}
		
		for (int run = 0; run < T; run++) {
			// 미세먼지 확산
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					now = run % 2;
					next = (run + 1) % 2;
					
					if (arr[now][r][c] < 1) continue;
					
					val = arr[now][r][c] / 5;
					sum = 0;
					
					sum += spread(r - 1, c);
					sum += spread(r + 1, c);
					sum += spread(r, c - 1);
					sum += spread(r, c + 1);
					arr[next][r][c] += arr[now][r][c] - sum;
					
					arr[now][r][c] = 0;
				}
			}
			
			// 공기청정기 on
			turnOn(0);
			turnOn(1);
		}
		
		int sum = 2; // 공기청정기 -1, -1 고려
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sum += arr[next][r][c];
			}
		}
		
		System.out.println(sum);
		
		br.close();
	}
	
	static int spread(int r, int c) {
		if (r < 0 || c < 0) return 0;
		if (r >= R || c >= C) return 0;
		if (arr[0][r][c] < 0) return 0;
		
		arr[next][r][c] += val;
		
		return val;
	}
	
	static void turnOn(int loc) {
		int r = A[loc];
		int c = 0;
		int idx = 0;
		int nr = 0;
		int nc = 0;
		
		while (true) {
			nr = r + move[loc][idx][0];
			nc = c + move[loc][idx][1];
			
			if (loc == 0 && nr > A[loc]) idx = (idx + 5) % 4;
			if (loc == 1 && nr < A[loc]) idx = (idx + 5) % 4;
			
			if (nr < 0 || nc < 0) idx = (idx + 5) % 4;
			if (nr >= R || nc >= C) idx = (idx + 5) % 4;
			
			nr = r + move[loc][idx][0];
			nc = c + move[loc][idx][1];
			
			if (arr[now][nr][nc] < 0) break;
			
			arr[next][r][c] = arr[next][nr][nc];
			
			r = nr;
			c = nc;
		}
		
		arr[next][r][c] = 0;
		arr[next][r][c - 1] = -1;
	}
}