import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long numerator[] = new long[2]; // 분자 n!
		long denominator[] = new long[2]; // 분모 (n - m)! * m!
		
		for (long num = 2; num <= n; num *= 2) {
			numerator[0] += n / num;
		}
		for (long num = 5; num <= n; num *= 5) {
			numerator[1] += n / num;
		}
		
		for (long num = 2; num <= n - m; num *= 2) {
			denominator[0] += (n - m) / num;
		}
		for (long num = 5; num <= n - m; num *= 5) {
			denominator[1] += (n - m) / num;
		}
		
		for (long num = 2; num <= m; num *= 2) {
			denominator[0] += m / num;
		}
		for (long num = 5; num <= m; num *= 5) {
			denominator[1] += m / num;
		}
		
		bw.write(Long.toString(Math.min(numerator[0] - denominator[0], numerator[1] - denominator[1]))); 
		bw.flush();

		br.close();
		bw.close();
	}
}