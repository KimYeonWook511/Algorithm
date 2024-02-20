import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int R, C, arr[][][], time, cnt, temp, cur, next;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[2][R + 2][C + 2];
		
		for (int r = 1; r <= R; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 1; c <= C; c++) {
				if (st.nextToken().charAt(0) == '1') {
					arr[0][r][c] = 1;
					cnt++;
					
				} else {
					arr[0][r][c] = -1;
				}
			}
		}
		
		airFill(1, 1); // next = 0
		
		while (true) {
			time++;
			temp = 0;
			next = (cur + 1) % 2;
			copy();
			
			for (int r = 2; r < R; r++) {
				for (int c = 2; c < C; c++) {
					if (arr[cur][r][c] == 1) {
						// 사방이 공기가 아닌 경우
						if (arr[cur][r - 1][c] != 0 && arr[cur][r + 1][c] != 0 && arr[cur][r][c - 1] != 0 && arr[cur][r][c + 1] != 0) continue;
						
						// 사방중 하나라도 공기인 경우
						airFill(r, c);
						temp++;
					}
				}
			}
			
			if (cnt - temp == 0) break;
			
			cnt -= temp;
			cur = next;
		}
		
		System.out.println(time + "\n" + cnt);
		
		br.close();
	}

	static void copy() {
		for (int r = 2; r < R; r++) {
			for (int c = 2; c < C; c++) {
				arr[next][r][c] = arr[cur][r][c];
			}
		}
	}
	
	static void airFill(int r, int c) {
		arr[next][r][c] = 0;
		
		// 가짜 공기(-1) -> AIR 변환
		if (arr[next][r - 1][c] == -1) airFill(r - 1, c);
		if (arr[next][r + 1][c] == -1) airFill(r + 1, c);
		if (arr[next][r][c - 1] == -1) airFill(r, c - 1);
		if (arr[next][r][c + 1] == -1) airFill(r, c + 1);
	}
}