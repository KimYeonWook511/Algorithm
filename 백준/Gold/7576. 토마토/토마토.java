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
        
        int arr[][] = new int[M][N];
        Deque<int[]> deque = new ArrayDeque<>();
        int cnt = 0;
        
        for (int r = 0; r < M; r++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for (int c = 0; c < N; c++) {
        		arr[r][c] = Integer.parseInt(st.nextToken());
        		
        		if (arr[r][c] == 1) {
        			deque.offerLast(new int[] {r, c});
        			cnt++;
        			
        		} else if (arr[r][c] == 0) {
        			cnt++; 
        		}
        	}
        }
        
        int max = 1;
        
        while (!deque.isEmpty()) {
        	int cur[] = deque.pollFirst();
        	int r = cur[0];
        	int c = cur[1];
        	
        	cnt--;
        	max = Math.max(max, arr[r][c]);
        	
        	if (r - 1 >= 0 && arr[r - 1][c] == 0) {
        		arr[r - 1][c] = arr[r][c] + 1;
        		deque.offer(new int[] {r - 1, c});
        	}
        	
        	if (r + 1 < M && arr[r + 1][c] == 0) {
        		arr[r + 1][c] = arr[r][c] + 1;
        		deque.offer(new int[] {r + 1, c});
        	}
        	
        	if (c - 1 >= 0 && arr[r][c - 1] == 0) {
        		arr[r][c - 1] = arr[r][c] + 1;
        		deque.offer(new int[] {r, c - 1});
        	}
        	
        	if (c + 1 < N && arr[r][c + 1] == 0) {
        		arr[r][c + 1] = arr[r][c] + 1;
        		deque.offer(new int[] {r, c + 1});
        	}
        }
        
        System.out.println(cnt == 0 ? max - 1 : "-1");
        
        br.close();
    }
}