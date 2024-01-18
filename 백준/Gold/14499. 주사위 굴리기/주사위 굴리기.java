import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, x, y, K, arr[][];
	static int top = 1;
	static int right = 3;
	static int front = 5;
	static int val[][] = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	static int dice[] = {0, 0, 0, 0, 0, 0, 0}; 
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int run = 0; run < K; run++) {
			move(Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	public static void move(int k) {
		int r = x + val[k][0];
		int c = y + val[k][1];
		
		if (r < 0 || c < 0) return;
		if (r >= N || c >= M) return;
		
		x = r;
		y = c;
		
		change(k);
	}
	
	public static void change(int k) {
		int temp = 0;
		
		if (k == 1) {
			temp = right;
			
			right = top;
			top = 7 - temp;
			
		} else if (k == 2) {
			temp = top;
			
			top = right;
			right = 7 - temp;
			
		} else if (k == 3) {
			temp = top;
			
			top = front;
			front = 7 - temp;
			
		} else {
			temp = front;
			
			front = top;
			top = 7 - temp;
		}
		
		chk();
		
		sb.append(dice[top]).append("\n");
	}
	
	public static void chk() {
		if (arr[x][y] == 0) {
			arr[x][y] = dice[7 - top];
			
		} else {
			dice[7 - top] = arr[x][y];
			arr[x][y] = 0;
		}
	}
}