import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			st = new StringTokenizer(br.readLine());
			BigInteger n = new BigInteger(st.nextToken());
			BigInteger m = new BigInteger(st.nextToken());
			
			bw.write(factorial(m).divide(factorial(m.subtract(n)).multiply(factorial(n))).toString() + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
	
	static BigInteger factorial(BigInteger num) {
		if (num.equals(new BigInteger("0"))) return new BigInteger("1");
		
		return num.multiply(factorial(num.subtract(new BigInteger("1"))));
	}
}