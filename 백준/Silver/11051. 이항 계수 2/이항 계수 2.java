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
		
		st = new StringTokenizer(br.readLine());
		BigInteger n = new BigInteger(st.nextToken());
		BigInteger k = new BigInteger(st.nextToken());
		
		BigInteger result = factorial(n).divide(factorial(n.subtract(k)).multiply(factorial(k))).mod(new BigInteger("10007"));
		
		bw.write(result.toString());
		bw.flush();

		br.close();
		bw.close();
	}
	
	static BigInteger factorial(BigInteger num) {
		if (num.equals(new BigInteger("0"))) return new BigInteger("1");
		
		return num.multiply(factorial(num.subtract(new BigInteger("1"))));
	}
}