import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int operand[]; // 피연산자 배열
	static int operatorCnt[] = new int[4]; // 연산자 배열[+, -, *, /]
	static int max = -1_000_000_000;
	static int min = 1_000_000_000;
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		operand = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			operand[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operatorCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		int operator[] = new int[n - 1];
		
		dfs(0, operator);
		
		bw.write(max + "\n" + min);
		bw.flush();

		br.close();
		bw.close();
	}
	
	static void dfs(int cnt, int[] operator) throws IOException {
		if (cnt == n - 1) { // 재귀 종료
			int result = cal(operator);
			
			if (result > max) max = result;
			if (result < min) min = result;
			
			return;
		};
		
		for (int i = 0; i < 4; i++) {
			if (operatorCnt[i] > 0) {
				// 해당 피연산자가 아직 남아있는 경우
				operator[cnt] = i;
				operatorCnt[i]--;
				dfs(cnt + 1, operator);
				operatorCnt[i]++;
			}
		}
	}
	
	static int cal(int operator[]) {
		int result = operand[0];
		
		for (int i = 1; i < n; i++) {
			switch (operator[i - 1]) {
			case 0: // + 
				result += operand[i];
				break;
			case 1: // -
				result -= operand[i];
				break;
			case 2: // *
				result *= operand[i];
				break;
			case 3: // /
				result /= operand[i];
				break;
			}
		}
		
		return result;
	}
}