import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean notPrime[] = new boolean[1_000_001];
		int sqrt = (int)Math.sqrt(1_000_000);
//		notPrime[0] = true; // (N - i)해도 1이상임
		notPrime[1] = true;
		
		for (int i = 2; i <= sqrt; i++) {
			if (notPrime[i]) continue;
			
			for (int k = i * i; k <= 1_000_000; k += i) {
				notPrime[k] = true;
			}
		}
				
				
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			
			for (int i = N >> 1; i >= 2; i--) {
				if (notPrime[i] || notPrime[N - i]) continue;
				
				cnt++;
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}