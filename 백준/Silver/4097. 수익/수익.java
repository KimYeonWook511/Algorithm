import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			int N = Integer.parseInt(br.readLine());
			
			if (N == 0) break;
			
			int sum = 0;
			int result = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(br.readLine());
				
				sum += num;
				result = Math.max(result, sum);
				
				if (sum < 0) sum = 0;
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);

		br.close();
	}
}