import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static boolean arr[][], chk[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new boolean[N][N];
		chk = new boolean[N];
		
		for (int run = 0; run < M; run++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			arr[x][y] = true;
			arr[y][x] = true;
		}
		
		func(0);
		
		System.out.println(cnt);
		
		br.close();
	}
	
	static void func(int search) {
		chk[search] = true;
		
		for (int i = 0; i < N; i++) {
			if (chk[i]) continue;
			
			if (arr[search][i] || arr[i][search]) {
				cnt++;
				func(i);
			}
		}
	}
}