import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, R, arr[][], result[][];
	static int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int idx, nr, nc;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		result = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		for (int i = Math.min(N, M) / 2 - 1; i >= 0; i--) {
			int maxR = N - 2 * i;
			int maxC = M - 2 * i;
			
			int move = R % (2 * maxR + 2 * maxC - 4);
			int temp[] = {maxC, maxR, maxC, maxR};
			
			nr = i;
			nc = i;
			idx = -1;
			
			while (move >= 0) { // 최대 4번
				idx++;
				
				nr += d[idx][0] * Math.min(maxR - 1, move);
				nc += d[idx][1] * Math.min(maxC - 1, move);
				
				move -= temp[idx] - 1;
			}
			
			for (int k = 0; k < maxC; k++) {
				result[i][k + i] = arr[nr][nc];
				chk(i, maxR, maxC);
			}
			
			for (int k = 1; k < maxR; k++) {
				result[k + i][i + maxC - 1] = arr[nr][nc];
				chk(i, maxR, maxC);
			}
			
			for (int k = maxC - 2; k >= 0; k--) {
				result[i + maxR - 1][k + i] = arr[nr][nc];
				chk(i, maxR, maxC);
			}
			
			for (int k = maxR - 2; k > 0; k--) {
				result[k + i][i] = arr[nr][nc];
				chk(i, maxR, maxC);
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				sb.append(result[r][c]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static void chk(int i, int maxR, int maxC) {
		if (nr + d[idx][0] < i || nc + d[idx][1] < i) idx = (idx + 5) % 4;
		else if (nr + d[idx][0] >= i + maxR || nc + d[idx][1] >= i + maxC) idx = (idx + 5) % 4;
		
		nr = nr + d[idx][0];
		nc = nc + d[idx][1];
	}
}