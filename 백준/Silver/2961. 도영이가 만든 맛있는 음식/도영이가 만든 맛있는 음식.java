import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author 김연욱 
 * @date 24.02.01
 * @link https://www.acmicpc.net/problem/2961
 * @keyword_solution 
 * - 물은 요리가 아니다
 * - "모든 재료를 사용해서 요리를 만들었을 때, 그 요리의 신맛과 쓴맛은 모두 1,000,000,000보다 작은 양의 정수이다."
 * - 요리의 맛이 양의 정수일 뿐 재료의 맛은 음수일 수 있지 않나..
 * @input 
 * - 1 ≤ N ≤ 10 (재료의 개수)
 * - 1 ≤ 신 맛, 쓴 맛 ≤ 1,000,000,000 (모든 재료를 사용했을 때의 요리의 맛)
 * @output 
 * - 신맛과 쓴맛의 차이가 최소인 것
 * - 재료는 최소 하나 사용해야 함
 * @time_complex 
 * @perf
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int taste[][], min;
	
	public static void main(String[] args) throws Exception {
	
		N = Integer.parseInt(br.readLine());
		
		taste = new int[N][2];
		min = 1_000_000_000;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}

		func(0, 1, 0, false);
		
		System.out.println(min);

		br.close();
	}
	
	static void func(int depth, int taste0, int taste1, boolean flag) { // 0: 신 맛, 1: 쓴 맛
		if (depth == N) {
			if (flag) min = Math.min(min, Math.abs(taste0 - taste1));

			return;
		}
		
		func(depth + 1, taste0, taste1, flag | false);
		func(depth + 1, taste0 * taste[depth][0], taste1 + taste[depth][1], true);
	}
}