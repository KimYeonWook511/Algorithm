import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author 김연욱 
 * @date 24.01.31
 * @link https://www.acmicpc.net/problem/11659
 * @keyword_solution i번째 수부터 j번째 수까지의 합 
 * @input
 * - 1 <= N <= 100,000
 * - 1 <= M <= 100,000
 * - 1 <= i <= j <= N
 * @output
 * - 100,000 * 1,000 = 100,000,000
 * @time_complex O(N + M) -> O(N)
 * @perf 56412KB | 564ms
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, arr[];

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		for (int run = 0; run < M; run++) {
			st = new StringTokenizer(br.readLine());

			int startIdx = Integer.parseInt(st.nextToken()) - 1;
			int endIdx = Integer.parseInt(st.nextToken());
            
            sb.append(arr[endIdx] - arr[startIdx]).append("\n");
		}
        
        System.out.println(sb);

		br.close();
	}
}