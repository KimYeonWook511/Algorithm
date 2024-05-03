import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Loc {
		int r, c, hp;
		
		Loc(int r, int c, int hp) {
			this.r = r;
			this.c = c;
			this.hp = hp;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char arr[][] = new char[N][M];
		PriorityQueue<Loc> pq = new PriorityQueue<>(new Comparator<Loc>() {
			@Override
			public int compare(Loc o1, Loc o2) {
				return Integer.compare(o1.hp, o2.hp);
			}
		});
		int dp[][] = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			
			for (int c = 0; c < M; c++) {
				arr[r][c] = line.charAt(c);
				
				if (arr[r][c] == 'C') {
					pq.offer(new Loc(r, c, 0));
					dp[r][c] = 0;
				}
				
				dp[r][c] = Integer.MAX_VALUE;
			}
		}
		
		String result = "dodo sad";
		
		while (!pq.isEmpty()) {
			Loc cur = pq.poll();
			
			if (arr[cur.r][cur.c] == 'E') {
				result = Integer.toString(cur.hp);
				break;
			}
			
			// 현재 위치에서 떨어지기
			if (arr[cur.r][cur.c] == 'X') {
				boolean flag = false;
				cur.hp += 10;
				
				while (++cur.r < N) { // 여긴 무조건 true
					if (arr[cur.r][cur.c] == 'D' || dp[cur.r][cur.c] <= cur.hp) {
						flag = true;
						break;
					}
					
					dp[cur.r][cur.c] = cur.hp;
					
					if (arr[cur.r][cur.c] == 'X') continue;
					
					break;
				}
				
				if (!flag) pq.offer(cur);
				
				continue;
			}
			
			// 위로 사다리
			if (arr[cur.r][cur.c] == 'L' && cur.r > 0 && dp[cur.r - 1][cur.c] > cur.hp + 5 && arr[cur.r - 1][cur.c] != 'D') {
				pq.offer(new Loc(cur.r - 1, cur.c, cur.hp + 5));
				dp[cur.r - 1][cur.c] = cur.hp + 5;
			}
			
			// 아래로 사다리
			if (cur.r + 1 < N && arr[cur.r + 1][cur.c] == 'L' && dp[cur.r + 1][cur.c] > cur.hp + 5) {
				pq.offer(new Loc(cur.r + 1, cur.c, cur.hp + 5));
				dp[cur.r + 1][cur.c] = cur.hp + 5;
			}
			
			// 좌로 이동
			if (cur.c > 0 && arr[cur.r][cur.c - 1] != 'D' && dp[cur.r][cur.c - 1] > cur.hp + 1) {
				pq.offer(new Loc(cur.r, cur.c - 1, cur.hp + 1));
				dp[cur.r][cur.c - 1] = cur.hp + 1;
			}
			
			// 우로 이동
			if (cur.c + 1 < M && arr[cur.r][cur.c + 1] != 'D' && dp[cur.r][cur.c + 1] > cur.hp + 1) {
				pq.offer(new Loc(cur.r, cur.c + 1, cur.hp + 1));
				dp[cur.r][cur.c + 1] = cur.hp + 1;
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}