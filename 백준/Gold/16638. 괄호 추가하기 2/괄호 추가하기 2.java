import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N, max = Integer.MIN_VALUE;
	static char arr[];
	
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N];
		
		String str = br.readLine();
		for (int i = 0; i < N; i++) {
			arr[i] = str.charAt(i);
		}
		
		N--; // 배열의 끝이랑 맞추기
		
		if (N == 0) {
			max = arr[0] - '0';
			
		} else {
			func(2, arr[0] - '0', 0, '+'); // 기본 연산
			if (arr[1] != '*') func(4, cal(arr[0] - '0', arr[1], arr[2] - '0'), 0, '+'); // 시작부터 괄호 연산
		}
		
		System.out.println(max);
		
		br.close();
	}
	
	static void func(int idx, int result, int temp, char tempOperator) {
		if (idx == N) { // 맨 끝
			if (arr[idx - 1] == '*') max = Math.max(max, cal(temp, tempOperator, cal(result, '*', arr[idx] - '0')));
			else max = Math.max(max, cal(cal(temp, tempOperator, result), arr[idx - 1], arr[idx] - '0'));
			
			return;
		}
		
		if (idx > N) { // 연산 끝 (초과)
			max = Math.max(max, cal(temp, tempOperator, result));
			
			return;
		}
		
		if (arr[idx - 1] == '*') {
			func(idx + 2, cal(result, '*', arr[idx] - '0'), temp, tempOperator); // case 1, 2
			func(idx + 4, cal(result, '*', cal(arr[idx] - '0', arr[idx + 1], arr[idx + 2] - '0')), temp, tempOperator); // case 3, 4
			
		} else {
			func(idx + 2, arr[idx] - '0', cal(temp, tempOperator, result), arr[idx - 1]); // case 5, 6
			func(idx + 4, cal(arr[idx] - '0', arr[idx + 1], arr[idx + 2] - '0'), cal(temp, tempOperator, result), arr[idx - 1]); // case 7, 8
		}
		
		// case (현재 idx는 X를 보고 있음)
		// 1. result * X *
		// 2. result * X +
		// 3. result * (X *
		// 4. result * (X +
		
		// 5. result + X *
		// 6. result + X +
		// 7. result + (X *
		// 8. result + (X +
	}
	
	static int cal(int op1, char operator, int op2) {
		switch (operator) {
			case '+':
				return op1 + op2;
			case '-':
				return op1 - op2;
			default: // '*'
				return op1 * op2;
		}
	}
}