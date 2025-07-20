import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		boolean prime[] = new boolean[b + 1]; // false: 소수
		int end = (int)Math.sqrt(b);
		
		for (int i = 2; i <= end; i++) {
			if (prime[i]) continue;

			for (int k = i * i; k <= b; k += i) {
				prime[k] = true;
			}
		}
		
		for (int i = a; i <= b; i++) {
			if (!prime[i] && chk(i)) sb.append(i).append("\n");
		}
		sb.append(-1);
		
		System.out.println(sb);
		
		br.close();
	}
	
	static boolean chk(int num) {
		String number = Integer.toString(num);
		
		int mid = number.length() >> 1;
		for (int i = 0; i < mid; i++) {
			if (number.charAt(i) != number.charAt(number.length() - 1 - i)) return false;
		}
		
		return true;
	}
}