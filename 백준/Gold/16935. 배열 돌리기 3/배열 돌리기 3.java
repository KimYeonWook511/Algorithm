import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M, R, arr[][][];
	static int maxR, maxC, step;
	static boolean isTurn = false;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		if (N > M) arr = new int[2][N][N];
		else arr = new int[2][M][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < M; c++) {
				arr[step][r][c] = Integer.parseInt(st.nextToken()); // step = 0 
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			step = i % 2;
			
			switch (Integer.parseInt(st.nextToken())) {
				case 1:
					func1();
					break;
					
				case 2:
					func2();
					break;
	
				case 3:
					func3();
					isTurn = !isTurn;
					break;
					
				case 4:
					func4();
					isTurn = !isTurn;
					break;
					
				case 5:
					func5();
					break;
					
				case 6:
					func6();
					break;
			}
		}
		
		
		if (isTurn) {
			maxR = M;
			maxC = N;
		} else {
			maxR = N;
			maxC = M;
		}
		
		step = (step + 1) % 2;
		
		for (int r = 0; r < maxR; r++) {
			for (int c = 0; c < maxC; c++) {
				sb.append(arr[step][r][c]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static void func1() { // 상하 반전
		if (isTurn) {
			maxR = M;
			maxC = N;
		} else {
			maxR = N;
			maxC = M;
		}
		
		for (int r = 0; r < (maxR >> 1); r++) {
			for (int c = 0; c < maxC; c++) {
				arr[(step + 1) % 2][r][c] = arr[step][maxR - 1 - r][c];
				arr[(step + 1) % 2][maxR - 1 - r][c] = arr[step][r][c];
			}
		}
	}
	
	static void func2() { // 좌우 반전
		if (isTurn) {
			maxR = M;
			maxC = N;
		} else {
			maxR = N;
			maxC = M;
		}
		
		for (int r = 0; r < maxR; r++) {
			for (int c = 0; c < (maxC >> 1); c++) {
				arr[(step + 1) % 2][r][c] = arr[step][r][maxC - 1 - c];
				arr[(step + 1) % 2][r][maxC - 1 - c] = arr[step][r][c];
			}
		}
	}
	
	static void func3() { // 오른쪽으로 90도 회전
		// (step + 1) % 2 의 크기
		if (isTurn) {
			maxR = N;
			maxC = M;
		} else {
			maxR = M;
			maxC = N;
		}
		
		for (int r = 0; r < maxR; r++) {
			for (int c = 0; c < maxC; c++) {
				arr[(step + 1) % 2][r][c] = arr[step][maxC - 1 - c][r];
			}
		}
	}
	
	static void func4() { // 왼쪽으로 90도 회전
		// (step + 1) % 2 의 크기
		if (isTurn) {
			maxR = N;
			maxC = M;
		} else {
			maxR = M;
			maxC = N;
		}
		
		for (int r = 0; r < maxR; r++) {
			for (int c = 0; c < maxC; c++) {
				arr[(step + 1) % 2][r][c] = arr[step][c][maxR - 1 - r];
			}
		}
	}
	
	static void func5() { // 시계 방향으로 변경
		if (isTurn) {
			maxR = M >> 1;
			maxC = N >> 1;
		} else {
			maxR = N >> 1;
			maxC = M >> 1;
		}
		
		for (int r = 0; r < maxR; r++) {
			for (int c = 0; c < maxC; c++) {
				arr[(step + 1) % 2][r][c] = arr[step][r + maxR][c];
			}
			
			for (int c = maxC; c < (maxC << 1); c++) {
				arr[(step + 1) % 2][r][c] = arr[step][r][c - maxC];
			}
		}
		
		for (int r = maxR; r < (maxR << 1) ; r++) {
			for (int c = 0; c < maxC; c++) {
				arr[(step + 1) % 2][r][c] = arr[step][r][c + maxC];
			}
			
			for (int c = maxC; c < (maxC << 1); c++) {
				arr[(step + 1) % 2][r][c] = arr[step][r - maxR][c];
			}
		}
	}
	
	static void func6() { // 반시계 방향으로 변경
		if (isTurn) {
			maxR = M >> 1;
			maxC = N >> 1;
		} else {
			maxR = N >> 1;
			maxC = M >> 1;
		}
		
		for (int r = 0; r < maxR; r++) {
			for (int c = 0; c < maxC; c++) {
				arr[(step + 1) % 2][r][c] = arr[step][r][c + maxC];
			}
			
			for (int c = maxC; c < (maxC << 1); c++) {
				arr[(step + 1) % 2][r][c] = arr[step][r + maxR][c];
			}
		}
		
		for (int r = maxR; r < (maxR << 1) ; r++) {
			for (int c = 0; c < maxC; c++) {
				arr[(step + 1) % 2][r][c] = arr[step][r - maxR][c];
			}
			
			for (int c = maxC; c < (maxC << 1); c++) {
				arr[(step + 1) % 2][r][c] = arr[step][r][c - maxC];
			}
		}
	}
}