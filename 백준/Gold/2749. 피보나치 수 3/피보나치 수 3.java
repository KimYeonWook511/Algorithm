import java.io.*;

public class Main {
	static final int MOD = 1_000_000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		int re = 15 * (int)Math.pow(10, (int)Math.log10(MOD) - 1);
		
		int fibo[] = new int[re + 1];
		fibo[1] = 1;
		
		for (int i = 2; i <= re; i++) {
			fibo[i] = (fibo[i - 2] + fibo[i - 1]) % MOD;
		}
		
		System.out.println(fibo[(int)(n % re)] % MOD);
		
		br.close();
	}
}