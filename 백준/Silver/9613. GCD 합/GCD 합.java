import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int t;
	static Integer arr[];
	
	public static void main(String[] args) throws IOException {
		t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			arr = new Integer[n];
			long sum = 0;
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, Collections.reverseOrder());
			
			for (int i = 0; i < n - 1; i++) {
				for (int k = i + 1; k < n; k++) {
					sum += gcd(arr[i], arr[k]);
				}
			}
			
			bw.write(sum + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
	
	static int gcd(int a, int b) {
		// 유클리드 호제법
		if (a % b == 0) return b;
		
		return gcd(b, a % b);
	}
}