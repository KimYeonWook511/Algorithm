import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char arr[][] = new char[N][N];
		int bCnt = 0;
		int eCnt = 0;
		int bCenter[] = new int[3];
		int eCenter[] = new int[3];
		
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			
			for (int c = 0 ; c < N; c++) {
				arr[r][c] = line.charAt(c);
				
				if (arr[r][c] == 'B') {
					if (++bCnt != 2) continue;
					
					if (c - 1 >= 0 && arr[r][c - 1] == 'B') bCenter[0] = 1; 
					
					bCenter[1] = r;
					bCenter[2] = c;
					
				} else if (arr[r][c] == 'E') {
					if (++eCnt != 2) continue;
					
					if (c - 1 >= 0 && arr[r][c - 1] == 'E') eCenter[0] = 1;
					
					eCenter[1] = r;
					eCenter[2] = c;
				}
			}
		}
		
		boolean chk[][][] = new boolean[2][N][N];
		Deque<int[]> deque = new ArrayDeque<>();
		deque.offer(new int[] {bCenter[0], bCenter[1], bCenter[2], 0});
		chk[bCenter[0]][bCenter[1]][bCenter[2]] = true;
		
		int result = 0;
		
		while (!deque.isEmpty()) {
			int cur[] = deque.poll();
			
			if (cur[0] == eCenter[0] && cur[1] == eCenter[1] && cur[2] == eCenter[2]) {
				result = cur[3];
				break;
			}
			
			int nr, nc;
			if (cur[0] == 0) { // 세로
				for (int d = 0; d < 4; d++) {
					nr = cur[1] + dr[d];
					nc = cur[2] + dc[d];
					
					if (nr - 1 < 0 || nc < 0) continue;
					if (nr + 1 >= N || nc >= N) continue;
					if (chk[0][nr][nc]) continue;
					
					// 나무 체크
					if (arr[nr][nc] == '1') continue;
					if (arr[nr - 1][nc] == '1') continue;
					if (arr[nr + 1][nc] == '1') continue;
					
					chk[0][nr][nc] = true;
					deque.offer(new int[] {0, nr, nc, cur[3] + 1});
				}
				
				nr = cur[1];
				nc = cur[2];
				if (nc - 1 >= 0 && nc + 1 < N) {
					if (!chk[1][nr][nc]
							&& arr[nr - 1][nc - 1] != '1' && arr[nr][nc - 1] != '1' && arr[nr + 1][nc - 1] != '1'
							&& arr[nr - 1][nc + 1] != '1' && arr[nr][nc + 1] != '1' && arr[nr + 1][nc + 1] != '1') {
						chk[1][nr][nc] = true;
						deque.offer(new int[] {1, nr, nc, cur[3] + 1});
					}
				}
				
			} else { // 가로
				for (int d = 0; d < 4; d++) {
					nr = cur[1] + dr[d];
					nc = cur[2] + dc[d];
					
					if (nr < 0 || nc - 1 < 0) continue;
					if (nr >= N || nc + 1 >= N) continue;
					if (chk[1][nr][nc]) continue;
			
					// 나무 체크
					if (arr[nr][nc] == '1') continue;
					if (arr[nr][nc - 1] == '1') continue;
					if (arr[nr][nc + 1] == '1') continue;
					
					chk[1][nr][nc] = true;
					deque.offer(new int[] {1, nr, nc, cur[3] + 1});
				}
				
				nr = cur[1];
				nc = cur[2];
				if (nr - 1 >= 0 && nr + 1 < N) {
					if (!chk[0][nr][nc]
							&& arr[nr - 1][nc - 1] != '1' && arr[nr - 1][nc] != '1' && arr[nr - 1][nc + 1] != '1'
							&& arr[nr + 1][nc - 1] != '1' && arr[nr + 1][nc] != '1' && arr[nr + 1][nc + 1] != '1') {
						chk[0][nr][nc] = true;
						deque.offer(new int[] {0, nr, nc, cur[3] + 1});
					}
				}
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}