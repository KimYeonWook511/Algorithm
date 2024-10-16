import java.io.*;
import java.util.*;

public class Main {
	static class Lan {
		int idx, w;
		
		Lan (int idx, int w) {
			this.idx = idx;
			this.w = w;
		}
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int arr[][] = new int[N][N];
        int result = 0;
        
        PriorityQueue<Lan> pq = new PriorityQueue<>(new Comparator<Lan>() {
        	@Override
        	public int compare(Lan o1, Lan o2) {
        		return Integer.compare(o1.w, o2.w);
        	}
		});
        int minW[] = new int[N];
        boolean chk[] = new boolean[N];
        
        for (int r = 0; r < N; r++) {
        	String line = br.readLine();
        	
        	for (int c = 0; c < N; c++) {
        		char ch = line.charAt(c);
        		
        		if (ch == '0') continue;
        		
        		if (ch >= 'a' && ch <= 'z') arr[r][c] = ch - 'a' + 1;
        		else arr[r][c] = ch - 'A' + 27;
        		
        		result += arr[r][c];
        		
        		if (r == c) arr[r][c] = 0;
        		else if (arr[c][r] == 0 || arr[c][r] > arr[r][c]) arr[c][r] = arr[r][c];
        		else arr[r][c] = arr[c][r];
        	}
        	
        	minW[r] = Integer.MAX_VALUE;
        }
        
        pq.offer(new Lan(0, 0));
        minW[0] = 0;
        int cnt = N;
        Lan cur;
        
        while (!pq.isEmpty()) {
        	cur = pq.poll();
        	
        	if (chk[cur.idx]) continue;
        	chk[cur.idx] = true;
        	result -= cur.w;
        	
        	if (--cnt == 0) break;
        	
        	for (int next = 0; next < N; next++) {
        		if (chk[next]) continue;
        		if (arr[cur.idx][next] == 0) continue;
        		if (minW[next] <= arr[cur.idx][next]) continue;
        		
        		minW[next] = arr[cur.idx][next];
        		pq.offer(new Lan(next, arr[cur.idx][next]));
        	}
        }
        
        System.out.println(cnt == 0 ? result : "-1");
        
        br.close();
    }
}