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
	static Integer arr[];
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new Integer[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < n; i++) {
			int val = gcd(arr[0], arr[i]);
			bw.write((arr[0] / val) + "/" + (arr[i] / val) + "\n");
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