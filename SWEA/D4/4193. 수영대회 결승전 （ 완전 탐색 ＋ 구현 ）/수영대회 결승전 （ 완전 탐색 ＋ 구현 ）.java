import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	static int N, A, B, C, D, arr[][], min;
	static boolean chk[][];
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
        	N = Integer.parseInt(br.readLine());
        	
        	arr = new int[N][N];
        	chk = new boolean[N][N];
        	
        	for (int r = 0; r < N; r++) {
        		st = new StringTokenizer(br.readLine());
        		
        		for (int c = 0; c < N; c++) {
        			arr[r][c] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	st = new StringTokenizer(br.readLine());
        	A = Integer.parseInt(st.nextToken());
        	B = Integer.parseInt(st.nextToken());

        	st = new StringTokenizer(br.readLine());
        	C = Integer.parseInt(st.nextToken());
        	D = Integer.parseInt(st.nextToken());
        	
        	min = 500;
        	func(0, A, B);

            if (min == 500) min = -1;

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
    
    static void func(int time, int r, int c) {
    	if (r < 0 || c < 0) return;
    	if (r >= N || c >= N) return;
    	if (chk[r][c]) return;
    	if (time > min) return;
    	
    	if (r == C && c == D) {
    		min = Math.min(min, time);
    		return;
    	}
    	
    	chk[r][c] = true;
    	
    	if (r + 1 < N && arr[r + 1][c] != 1) {
    		if (arr[r + 1][c] == 2 && (time + 1) % 3 != 0) func((time / 3 + 1) * 3, r + 1, c); 
    		else func(time + 1, r + 1, c);
    	}
    	
    	if (r - 1 >= 0 && arr[r - 1][c] != 1) {
    		if (arr[r - 1][c] == 2 && (time + 1) % 3 != 0) func((time / 3 + 1) * 3, r - 1, c); 
    		else func(time + 1, r - 1, c);
    	}
    	
    	if (c + 1 < N && arr[r][c + 1] != 1) {
    		if (arr[r][c + 1] == 2 && (time + 1) % 3 != 0) func((time / 3 + 1) * 3, r, c + 1); 
    		else func(time + 1, r, c + 1);
    	}
    	
    	if (c - 1 >= 0 && arr[r][c - 1] != 1) {
    		if (arr[r][c - 1] == 2 && (time + 1) % 3 != 0) func((time / 3 + 1) * 3, r, c - 1); 
    		else func(time + 1, r, c - 1);
    	}
    	
    	chk[r][c] = false;
    }
}