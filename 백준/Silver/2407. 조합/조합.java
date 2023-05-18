import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		BigInteger result = new BigInteger("1");
		
		for (int i = n - (n - r) + 1; i <= n; i++) {
			result = result.multiply(new BigInteger(Integer.toString(i)));
		}
		
		for (int i = 2; i <= (n - r); i++) {
			result = result.divide(new BigInteger(Integer.toString(i)));
		}
		
		System.out.println(result.toString());
		
		br.close();
	}
}