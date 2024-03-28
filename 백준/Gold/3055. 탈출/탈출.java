import java.io.*;
import java.util.*;

public class Main {
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char arr[][] = new char[R][C];
		Deque<int[]> dequeS = new ArrayDeque<>();
		Deque<int[]> dequeW = new ArrayDeque<>();
		
		for (int r = 0; r < R; r++) {
			String line = br.readLine();
			
			for (int c = 0; c < C; c++) {
				char ch = arr[r][c] = line.charAt(c);
				
				if (ch == '*') dequeW.offer(new int[] {r, c});
				else if (ch == 'S') dequeS.offer(new int[] {r, c});
			}
		}
		
		int time = 0;
		boolean flag = false;
		
		while (!dequeS.isEmpty()) {
			time++;
			
			if (!dequeW.isEmpty()) {
				int size = dequeW.size();
				
				for (int i = 0; i < size; i++) {
					int cur[] = dequeW.poll();
					
					int nr, nc;
					for (int d = 0; d < 4; d++) {
						nr = cur[0] + dr[d];
						nc = cur[1] + dc[d];
						
						if (nr < 0 || nc < 0) continue;
						if (nr >= R || nc >= C) continue;
						if (arr[nr][nc] == 'S' || arr[nr][nc] != '.') continue;
						
						arr[nr][nc] = '*';
						dequeW.offer(new int[] {nr, nc});
					}
				}
			}
			
			int size = dequeS.size();
		
			for (int i = 0; i < size; i++) {
				int cur[] = dequeS.poll();
				
				int nr, nc;
				for (int d = 0; d < 4; d++) {
					nr = cur[0] + dr[d];
					nc = cur[1] + dc[d];
					
					if (nr < 0 || nc < 0) continue;
					if (nr >= R || nc >= C) continue;
					if (arr[nr][nc] == 'D') {
						flag = true;
						break;
					}
					if (arr[nr][nc] != '.') continue;
					
					arr[nr][nc] = 'S';
					dequeS.offer(new int[] {nr, nc});
				}
			}
			
			if (flag) break;
		}
		
		System.out.println(flag ? time : "KAKTUS");
		
		br.close();
	}
}