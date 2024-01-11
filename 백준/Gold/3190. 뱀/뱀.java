import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static class Loc {
		int r;
		int c;
		
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		boolean arr[][] = new boolean[N][N];
		
		for (int run = 0; run < K; run++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[r - 1][c - 1] = true;
		}
		
		int time = 0;
		int direction[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up
		int idx = 0;
		boolean flag = false;
		
		boolean chk[][] = new boolean[N][N];
		Deque<Loc> deq = new ArrayDeque<>();
		deq.offerFirst(new Loc(0, 0));
		
		int L = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < L; run++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char cmd = st.nextToken().charAt(0);
			
			while (time < t) {
				time++;
				
				Loc head = deq.peekFirst();
				int r = head.r + direction[idx][0];
				int c = head.c + direction[idx][1]; 
				
				if (r < 0 || c < 0) {
					flag = true;
					break;
				}
				if (r >= N || c >= N) {
					flag = true;
					break;
				}
				if (chk[r][c]) {
					flag = true;
					break;
				}
				
				deq.offerFirst(new Loc(r, c));
				chk[r][c] = true;
				
				if (!arr[r][c]) {
					Loc tail = deq.pollLast();
					chk[tail.r][tail.c] = false;
				}
				
				arr[r][c] = false; 
			}
			
			if (flag) break;
			
			if (cmd == 'D') idx = (idx + 5) % 4; 
			else idx = (3 + idx) % 4;
		}
		
		while (!flag) {
			time++;
			
			Loc head = deq.peekFirst();
			int r = head.r + direction[idx][0];
			int c = head.c + direction[idx][1]; 
			
			if (r < 0 || c < 0) {
				flag = true;
				break;
			}
			if (r >= N || c >= N) {
				flag = true;
				break;
			}
			if (chk[r][c]) {
				flag = true;
				break;
			}
			
			deq.offerFirst(new Loc(r, c));
			chk[r][c] = true;
			
			if (!arr[r][c]) {
				Loc tail = deq.pollLast();
				chk[tail.r][tail.c] = false;
			}
			
			arr[r][c] = false;
		}
		
		System.out.println(time);
		
		br.close();
	}
}