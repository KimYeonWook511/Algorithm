import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int r, c;
		int bit; // 가지고 있는 열쇠
		int m;
		
		Node(int r, int c, int bit, int m) {
			this.r = r;
			this.c = c;
			this.bit = bit;
			this.m = m;
		}
	}
	
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char arr[][] = new char[N][M];
		
		Deque<Node> deque = new ArrayDeque<>();
		
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			
			for (int c = 0; c < M; c++) {
				arr[r][c] = line.charAt(c);
				
				if (arr[r][c] == '0') {
					deque.offer(new Node(r, c, 0, 0));
					arr[r][c] = '.';
				}
			}
		}
		
		boolean chk[][][] = new boolean[(1 << 7) - 1][N][M];
		int min = Integer.MAX_VALUE;
		chk[0][deque.peek().r][deque.peek().c] = true;
		
		while (!deque.isEmpty()) {
			Node cur = deque.poll();
			
			if (cur.m >= min) continue;
			
			int nr, nc;
			for (int d = 0; d < 4; d++) {
				nr = cur.r + dr[d];
				nc = cur.c + dc[d];
				
				if (nr < 0 || nc < 0) continue;
				if (nr >= N || nc >= M) continue;
				if (chk[cur.bit][nr][nc]) continue;
				if (arr[nr][nc] == '#') continue;
			
				if (arr[nr][nc] == '.') {
					chk[cur.bit][nr][nc] = true;
					deque.offer(new Node(nr, nc, cur.bit, cur.m + 1));
					
				} else if (arr[nr][nc] == '1') {
					min = Math.min(min, cur.m + 1);
					
				} else if (arr[nr][nc] >= 'a' && arr[nr][nc] <= 'f') {
					int nb = (1 << (arr[nr][nc] - 'a'));
					
					if ((cur.bit & nb) == 0) {
						chk[cur.bit | nb][nr][nc] = true;
						deque.offer(new Node(nr, nc, cur.bit | nb, cur.m + 1));
					}
					
					chk[cur.bit][nr][nc] = true;
					deque.offer(new Node(nr, nc, cur.bit, cur.m + 1));
					
				} else if ((cur.bit & (1 << (arr[nr][nc] - 'A'))) != 0) {
					chk[cur.bit][nr][nc] = true;
					deque.offer(new Node(nr, nc, cur.bit, cur.m + 1));
				}
			}
		}
		
		System.out.println(min == Integer.MAX_VALUE ? "-1" : min);
		
		br.close();
	}
}