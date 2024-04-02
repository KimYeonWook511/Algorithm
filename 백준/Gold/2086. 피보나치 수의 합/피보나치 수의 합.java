import java.io.*;
import java.util.*;

public class Main {
	static final int MOD = 1_000_000_000;
	static Map<Integer, Long> map = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		int re = 15 * (int)Math.pow(10, Math.log10(MOD) - 1);
		
		int bRe = (int)((b + 2) % re);
		int aRe = (int)((a + 1) % re);
		
		long bSum = fibo(bRe);
		long aSum = fibo(aRe);
		
		System.out.println((bSum < aSum ? MOD + bSum - aSum : bSum - aSum) % MOD);
		
		br.close();
	}
	
	static long fibo(int n) {
		if (n == 0) return 0;
		if (n == 1 || n == 2) return 1;
		if (map.containsKey(n)) return map.get(n);
		
		long base = fibo(n >> 1);
		long val = 0;
		
		if ((n & 1) == 0) {
			long base2 = fibo((n >> 1) - 1);
			val = base * base % MOD + ((2 * base) % MOD) * base2 % MOD;
			
		} else {			
			long base2 = fibo((n >> 1) + 1);
			val = base * base % MOD + base2 * base2 % MOD;
		}
		
		val %= MOD;
		
		map.put(n, val);
		return val;
	}
}