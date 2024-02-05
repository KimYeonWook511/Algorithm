import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		boolean arr[][] = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < N; c++) {
				if (st.nextToken().equals("1")) arr[r][c] = true;
			}
		}
		
		for (int s = 0; s < N; s++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] |= arr[r][s] && arr[s][c];
				}
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				sb.append(arr[r][c] ? 1 : 0).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}