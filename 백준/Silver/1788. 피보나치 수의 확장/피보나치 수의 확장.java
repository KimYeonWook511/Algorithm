import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final int MOD = 1_000_000_000;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int absN = Math.abs(n);
		int fiboL = 0;
		int fiboR = 1;
		
		for (int i = 0; i < absN; i++) {
			int temp = fiboL + fiboR;
			fiboR = fiboL;
			fiboL = temp % MOD;
		}
		
		if (n == 0) {
			System.out.println(0);
			
		} else if (n < 0 && n % 2 == 0) {
			System.out.println(-1);
			
		} else {
			System.out.println(1);
		}
		
		System.out.println(fiboL);
		
		br.close();
	}
}