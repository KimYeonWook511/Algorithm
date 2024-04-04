import java.io.*;
import java.util.*;

public class Main {
	static class P {
		int r, c;
		boolean used;
		
		P(int r, int c) {
			this.r = r;
			this.c = c;
			this.used = false;
		}
	}
	
	static int square[] = {0, 5, 5, 5, 5, 5}; // 0, 1x1, 2x2, 3x3, 4x4, 5x5
	static int idx, result;
	static P arr[] = new P[100];
	static P map[][] = new P[10][10];
	static boolean chk[][][] = new boolean[10][10][6]; // r, c, 사이즈
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int r = 0; r < 10; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < 10; c++) {
				if (st.nextToken().charAt(0) == '0') continue;
				
				chk[r][c][1] = true;
				arr[idx] = new P(r, c);
				map[r][c] = arr[idx];
				idx++;
			}
		}
		
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (chk[r][c][1]) cal(r, c, 2);
			}
		}
		
		result = Integer.MAX_VALUE;
		func(0, 0, 0);
		
		System.out.println(result == Integer.MAX_VALUE ? "-1" : result);
		
		br.close();
	}
	
	static void cal(int r, int c, int i) {
		int endR = r + i - 1;
		int endC = c + i - 1;
		
		if (endR >= 10 || endC >= 10) return;
		
		// 우변
		for (int nr = r; nr < endR; nr++) {
			if (!chk[nr][endC][1]) return;
		}
		
		// 밑변
		for (int nc = c; nc < endC; nc++) { 
			if (!chk[endR][nc][1]) return;
		}

		// 우측 하단 꼭지점
		if (!chk[endR][endC][1]) return;
		
		chk[r][c][i] = true;
		
		if (i != 5) cal(r, c, i + 1);
	}
	
	static void func(int i, int cnt, int sum) {
		if (cnt >= result) return;
		
		if (sum == idx) {
			result = Math.min(result, cnt);
			return;
		}
		
		if (i == idx) return;
		
		for (int size = 1; size <= 5; size++) {
			if (square[size] == 0) continue;
			
			while (arr[i].used) {
				if (++i == idx) return;
			}
			
			if (!chk[arr[i].r][arr[i].c][size]) return;
			
			if (!dfs(arr[i].r, arr[i].c, arr[i].r, arr[i].c, size)) return;
			square[size]--;
			
			func(i + 1, cnt + 1, sum + size * size);
			
			rollback(arr[i].r, arr[i].c, size);
			square[size]++;
		}
	}
	
	static boolean dfs(int r, int c, int nr, int nc, int size) {
		if (nr == r + size) return true;
		if (map[nr][nc].used) return false;

		return map[nr][nc].used = (nc + 1 == c + size) ? dfs(r, c, nr + 1, c, size) : dfs(r, c, nr, nc + 1, size);
	}
	
	static void rollback(int r, int c, int size) {
		for (int dr = 0; dr < size; dr++) {
			for (int dc = 0; dc < size; dc++) {
				map[r + dr][c + dc].used = false;
			}
		}
	}
}