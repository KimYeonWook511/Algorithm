import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Point> graph[][] = new ArrayList[N + 1][N + 1];
		
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				graph[x][y] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[x][y].add(new Point(a, b)); 
		}
		
		Deque<Point> deque = new ArrayDeque<>();
		boolean visited[][] = new boolean[N + 1][N + 1]; // 돌아갈 수 있음
		boolean chk[][] = new boolean[N + 1][N + 1]; // 스위치 킴
		
		deque.offer(new Point(1, 1));
		visited[1][1] = true;
		chk[1][1] = true;
		
		int cnt = 1;
		
		while (!deque.isEmpty()) {
			Point cur = deque.poll();
			
			int nx, ny;
			for (Point next : graph[cur.x][cur.y]) {
				if (chk[next.x][next.y]) continue;
				
				chk[next.x][next.y] = true;
				cnt++;
				
				for (int d = 0; d < 4; d++) {
					nx = next.x + dx[d];
					ny = next.y + dy[d];
					
					if (nx < 1 || ny < 1) continue;
					if (nx > N || ny > N) continue;
					if (!visited[nx][ny]) continue; 
					
					visited[next.x][next.y] = true;
					deque.offer(next);
					break;
				}
			}
			
			for (int d = 0; d < 4; d++) {
				nx = cur.x + dx[d];
				ny = cur.y + dy[d];
				
				if (nx < 1 || ny < 1) continue;
				if (nx > N || ny > N) continue;
				if (!chk[nx][ny]) continue;
				if (visited[nx][ny]) continue;
					
				visited[nx][ny] = true;
				deque.offer(new Point(nx, ny));
			}
		}
		
		System.out.println(cnt);
		
		br.close();
	}
}