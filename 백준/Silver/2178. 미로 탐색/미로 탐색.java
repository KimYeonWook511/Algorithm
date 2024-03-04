import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        boolean arr[][] = new boolean[N + 2][M + 2];

        String line = "";
        for (int r = 1; r <= N; r++) {
        	line = br.readLine();
        	
        	for (int c = 1; c <= M; c++) {
        		if (line.charAt(c - 1) == '1') arr[r][c] = true;
        	}
        }
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[] {1, 1, 1});
        
        boolean chk[][] = new boolean[N + 2][M + 2];
        chk[1][1] = true;
        
        while (!deque.isEmpty()) {
        	int cur[] = deque.pollFirst();
        	int r = cur[0];
        	int c = cur[1];
        	int cnt = cur[2];
        	
        	if (r == N && c == M) {
        		System.out.println(cnt);
        		break;
        	}
        	
        	if (arr[r - 1][c] && !chk[r - 1][c]) {
        		chk[r - 1][c] = true;
        		deque.offer(new int[] {r - 1, c, cnt + 1});
        	}
        	
        	if (arr[r + 1][c] && !chk[r + 1][c]) {
        		chk[r + 1][c] = true;
        		deque.offer(new int[] {r + 1, c, cnt + 1});
        	}
        	
        	if (arr[r][c - 1] && !chk[r][c - 1]) {
        		chk[r][c - 1] = true;
        		deque.offer(new int[] {r, c - 1, cnt + 1});
        	}
        	
        	if (arr[r][c + 1] && !chk[r][c + 1]) {
        		chk[r][c + 1] = true;
        		deque.offer(new int[] {r, c + 1, cnt + 1});
        	}
        }
        
        br.close();
    }
}