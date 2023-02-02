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
		int k = Integer.parseInt(st.nextToken());
		
		bw.write(Integer.toString(factorial(n) / (factorial(k) * factorial(n - k))));
		
		bw.flush();

		br.close();
		bw.close();
	}
	
	static int factorial(int num) {
		if (num == 0) return 1;
		
		return num * factorial(num - 1);
	}
}