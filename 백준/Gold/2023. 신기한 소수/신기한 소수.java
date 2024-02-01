import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @author 김연욱 
 * @date 24.02.01
 * @link https://www.acmicpc.net/problem/2023
 * @keyword_solution  
 * @input
 * - ** 메모리 4MB **
 * - N = 8이 최대
 * - (N=8) 10,000,000 최소값 -> 루트(10^7) -> 10^3*10^0.5 -> 1000*3.xx -> 3000번 연산
 * - (N=8) 10,000,000 - 1 최대값 -> 루트(10^8) -> 10^4 -> 10000 -> 10000번 연산
 * - 짝수 제외 -> 4500만개
 * @output
 * @time_complex 
 * @perf 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		
		func(1, 2);
		
		for (int i = 3; i <= 7; i += 2) {
			func(1, i);
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static void func(int depth, int num) {
		if (!chk(num)) return;
		
		if (depth == N) {
			sb.append(num).append("\n");
			
			return;
		}
		
		for (int i = 1; i < 10; i += 2) {
			func(depth + 1, num * 10 + i);; 
		}
	}
	
	static boolean chk(int num) {
		if (num == 1) return false;
		
		// 공약수
		for (int i = (int)Math.sqrt(num); i >= 2; i--) {
            if (num % i == 0) {
                return false;
            }
        }
		
		return true;
	}
}