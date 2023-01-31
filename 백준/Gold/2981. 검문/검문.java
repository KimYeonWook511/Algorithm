import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		
		for (int run = 0; run < n; run++) {
			arr[run] = Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		
		for (int i = 0; i < n - 1; i++) {
			result = gcd(result, Math.abs(arr[i] - arr[i + 1]));
		}
		
		for (int i = 2; i <= result; i++) {
			if (result % i == 0) bw.write(i + " ");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
	
	static int gcd(int a, int b) {
		// 유클리드 호제법 참고함
		if (a % b == 0) return b;
		
		return gcd(b, a % b);
	}
}