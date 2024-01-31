import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, dist[][], distMin[], min = Integer.MAX_VALUE;
	static int homeCnt, chickenCnt;
	static char arr[][];
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N + 1][N + 1];
		
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 1; c <= N; c++) {
				arr[r][c] = st.nextToken().charAt(0);
				
				switch (arr[r][c]) {
					case '1':
						homeCnt++;
						break;
					case '2':
						chickenCnt++;
						break;
				}
			}
		}

		dist = new int[chickenCnt][homeCnt];
		distMin = new int[homeCnt];
		
		chickenCnt = 0;

		// 각 치킨집 별로 집과의 거리 계산
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (arr[r][c] == '2') cal(r, c, chickenCnt++);
			}
		}
		
		// 초기화 작업
		for (int i = 0; i < homeCnt; i++) {
			distMin[i] = 100;
		}
		
		// 최소값 구하기
		func(0, 0);
		
		System.out.println(min);
		
		br.close();
	}
	
	static void func(int depth, int startIdx) {
		if (depth == M) {
			int sum = 0;
			
			for (int i = 0; i < homeCnt; i++) {
				sum += distMin[i];
			}
			
			min = Math.min(min, sum);
			return;
		}
		
		int tempMin[] = new int[homeCnt];
		
		for (int ci = startIdx; ci < chickenCnt; ci++) {
			for (int i = 0; i < homeCnt; i++) {
				tempMin[i] = distMin[i];
				distMin[i] = Math.min(distMin[i], dist[ci][i]);
			}
			
			func(depth + 1, ci + 1);
			
			for (int i = 0; i < homeCnt; i++) {
				distMin[i] = tempMin[i];
			}
		}
	}
	
	static void cal(int r, int c, int chickenCnt) {
		homeCnt = 0;
		
		for (int sr = 1; sr <= N; sr++) {
			for (int sc = 1; sc <= N; sc++) {
				if (arr[sr][sc] == '1') {
					dist[chickenCnt][homeCnt++] = Math.abs(sr - r) + Math.abs(sc - c);
				}
			}
		}
	}
}