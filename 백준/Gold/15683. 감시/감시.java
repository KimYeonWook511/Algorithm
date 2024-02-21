import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, roomCnt, cctvCnt, cctv[][], min = Integer.MAX_VALUE;
	static char arr[][];
	static boolean selectD[][];
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		cctv = new int[8][2];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < M; c++) {
				arr[r][c] = st.nextToken().charAt(0);
				
				if (arr[r][c] == '0') roomCnt++;
				else if (arr[r][c] != '6') {
					cctv[cctvCnt][0] = r;
					cctv[cctvCnt++][1] = c;
				}
			}
		}
		
		selectD = new boolean[cctvCnt][4]; // 해당 인덱스의 cctv가 바라보는 방향 
		
		func(0);
		
		System.out.println(min);
		
		br.close();
	}
	
	static void func(int cctvIdx) {
		if (cctvIdx == cctvCnt) {
			cal();

			return;
		}
		
		int r = cctv[cctvIdx][0];
		int c = cctv[cctvIdx][1];
		
		if (arr[r][c] == '1') {
			for (int d = 0; d < 4; d++) {
				selectD[cctvIdx][d] = true;
				func(cctvIdx + 1);
				selectD[cctvIdx][d] = false;
			}
			
		} else if (arr[r][c] == '2') {
			for (int d = 0; d < 2; d++) {
				selectD[cctvIdx][d] = selectD[cctvIdx][d + 2] = true;
				func(cctvIdx + 1);
				selectD[cctvIdx][d] = selectD[cctvIdx][d + 2] = false;
			}
			
		} else if (arr[r][c] == '3') {
			for (int d = 0; d < 4; d++) {
				selectD[cctvIdx][d] = selectD[cctvIdx][(d + 5) % 4] = true;
				func(cctvIdx + 1);
				selectD[cctvIdx][d] = selectD[cctvIdx][(d + 5) % 4] = false;
			}
			
		} else if (arr[r][c] == '4') {
			selectD[cctvIdx][0] = selectD[cctvIdx][1] = selectD[cctvIdx][2] = selectD[cctvIdx][3] = true;
					
			for (int d = 0; d < 4; d++) {
				selectD[cctvIdx][d] = false;
				func(cctvIdx + 1);
				selectD[cctvIdx][d] = true;
			}
			
		} else {
			selectD[cctvIdx][0] = selectD[cctvIdx][1] = selectD[cctvIdx][2] = selectD[cctvIdx][3] = true;
			
			func(cctvIdx + 1);
		}
	}
	
	static void cal() {
		int cnt = 0;
		
		boolean chk[][] = new boolean[N][M];

		for (int i = 0; i < cctvCnt; i++) {
			int r = cctv[i][0];
			int c = cctv[i][1];
			
			if (selectD[i][0]) {
				int nr = r - 1;
				int nc = c;
				
				while (nr >= 0) {
					if (arr[nr][nc] == '6') break;
					if (!chk[nr][nc] && arr[nr][nc] == '0') cnt++;
					
					chk[nr][nc] = true;
					nr--;
				}
			}
			
			if (selectD[i][1]) {
				int nr = r;
				int nc = c + 1;
				
				while (nc < M) {
					if (arr[nr][nc] == '6') break;
					if (!chk[nr][nc] && arr[nr][nc] == '0') cnt++;
					
					chk[nr][nc] = true;
					nc++;
				}
			}
			
			if (selectD[i][2]) {
				int nr = r + 1;
				int nc = c;
				
				while (nr < N) {
					if (arr[nr][nc] == '6') break;
					if (!chk[nr][nc] && arr[nr][nc] == '0') cnt++;
					
					chk[nr][nc] = true;
					nr++;
				}
			}
			
			if (selectD[i][3]) {
				int nr = r;
				int nc = c - 1;
				
				while (nc >= 0) {
					if (arr[nr][nc] == '6') break;
					if (!chk[nr][nc] && arr[nr][nc] == '0') cnt++;
					
					chk[nr][nc] = true;
					nc--;
				}
			}
		}
		
		min = Math.min(min, roomCnt - cnt);
	}
}