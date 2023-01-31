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
	static int n;
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			bw.write(gcd(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");
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