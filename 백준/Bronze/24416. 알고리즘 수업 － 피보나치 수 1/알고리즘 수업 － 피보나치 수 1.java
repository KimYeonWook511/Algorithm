import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		bw.write(fib(n) + " " + fibonacci(n));
		bw.flush();

		br.close();
		bw.close();
	}
	
	static int fib(int n) {
		if (n == 1 || n == 2) return 1;
		else return fib(n - 1) + fib(n - 2);
	}
	
	static int fibonacci(int n) {
		int f[] = new int[n];
		f[0] = 1;
		f[1] = 1;
		int cnt = 0; // 실행 횟수
		
		for (int i = 2; i < n; i++) {
			f[i] = f[i - 1] + f[i - 2];
			cnt++;
		}
		
		return cnt;
	}
}