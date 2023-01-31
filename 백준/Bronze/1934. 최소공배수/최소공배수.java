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
	static int t;
	static int a, b;
	static int result = 1;
	
	public static void main(String[] args) throws IOException {
		t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for (int i = 2; i <= (a < b ? a : b); i++) {
				while (true) {
					if (a % i != 0 || b % i != 0) break;
					
					result *= i;
					a /= i;
					b /= i;
				}
			}
			
			bw.write(result * a * b + "\n"); // 최소 공배수
			result = 1;
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}