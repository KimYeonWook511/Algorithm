import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, cnt[] = new int[4];
    static int arr[];
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static Deque<Integer> operand = new ArrayDeque<>(); 

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
        
		operand.offerLast(arr[0]);
		
		func(1, ' ');
		
        System.out.println(max + "\n" + min);

		br.close();
	}
	
	static void func(int depth, char tempOperator) {
		int op1 = tempOperator != ' ' ? operand.pollFirst() : 0;
		int op2 = operand.pollLast();
		
		if (depth == N) {
			if (tempOperator != ' ') op2 = cal(op1, tempOperator, op2);
			
			max = Math.max(max, op2);
			min = Math.min(min, op2);
			
			return;
		}
		
		if (cnt[2] != 0) {
			cnt[2]--;
			
			operand.offerFirst(op1);
			operand.offerLast(op2 * arr[depth]);
			func(depth + 1, tempOperator);
			
			cnt[2]++;
		}
		
		if (cnt[3] != 0) {
			cnt[3]--;
			
			operand.offerFirst(op1);
			operand.offerLast(op2 / arr[depth]);
			func(depth + 1, tempOperator);
			
			cnt[3]++;
		}
		
		if (tempOperator != ' ') op2 = cal(op1, tempOperator, op2);
		
		if (cnt[0] != 0) {
			cnt[0]--;
			
			operand.offerFirst(op2);
			operand.offerLast(arr[depth]);
			func(depth + 1, '+');
			
			cnt[0]++;
		}

		if (cnt[1] != 0) {
			cnt[1]--;
			
			operand.offerFirst(op2);
			operand.offerLast(arr[depth]);
			func(depth + 1, '-');
			
			cnt[1]++;
		}
	}
	
	static int cal(int op1, char operator, int op2) {
		switch (operator) {
			case '+':
				return op1 + op2;
			default:
				return op1 - op2;
		}
	}
}