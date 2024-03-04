import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
        int N = Integer.parseInt(st.nextToken());
        
        boolean arr[][] = new boolean[N + 2][N + 2];

        String line = "";
        for (int r = 1; r <= N; r++) {
        	line = br.readLine();
        	
        	for (int c = 1; c <= N; c++) {
        		if (line.charAt(c - 1) == '1') arr[r][c] = true;
        	}
        }
        
        Deque<int[]> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for (int r = 1; r <= N; r++) {
        	for (int c = 1; c <= N; c++) {
        		if (!arr[r][c]) continue;
        			
        		int cnt = 0;
        		deque.offer(new int[] {r, c});
        		arr[r][c] = false;
        		
        		while (!deque.isEmpty()) {
                	int cur[] = deque.pollFirst();
                	int nr = cur[0];
                	int nc = cur[1];
                	
                	cnt++;
                	
                	if (arr[nr - 1][nc]) {
                		arr[nr - 1][nc] = false;
                		deque.offer(new int[] {nr - 1, nc});
                	}
                	
                	if (arr[nr + 1][nc]) {
                		arr[nr + 1][nc] = false;
                		deque.offer(new int[] {nr + 1, nc});
                	}
                	
                	if (arr[nr][nc - 1]) {
                		arr[nr][nc - 1] = false;
                		deque.offer(new int[] {nr, nc - 1});
                	}
                	
                	if (arr[nr][nc + 1]) {
                		arr[nr][nc + 1] = false;
                		deque.offer(new int[] {nr, nc + 1});
                	}
                }
        		
        		list.add(cnt);
        	}
        }
        
        Collections.sort(list);
        
        sb.append(list.size()).append("\n");
        for (int i : list) {
        	sb.append(i).append("\n");
        }
        
        System.out.println(sb);
        
        br.close();
    }
}