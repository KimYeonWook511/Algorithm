import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());

		sb.append(new BigInteger("2").pow(N).subtract(BigInteger.ONE)).append("\n");
		
		if (N <= 20) func(1, 3, 2, N);
		
		System.out.println(sb);
		
		br.close();
	}
	
	static void func(int start, int end, int middle, int top) { // middle은 6 - start - end
		if (top == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			
			return;
		}
		
		func(start, middle, end, top - 1); // N만 남기기 위해 N-1까지 다 옮기기
		sb.append(start).append(" ").append(end).append("\n"); // N을 End로 옮기기
		func(middle, end, start, top - 1); // 옮긴 N-1까지를 다시 옮기기
	}
}