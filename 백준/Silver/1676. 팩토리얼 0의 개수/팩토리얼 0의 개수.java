import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BigInteger n = new BigInteger(br.readLine());
		
		String num = factorial(n).toString();
		int cnt = 0;
		
		while (true) {
			int idx = num.lastIndexOf("0");
			
			if (num.length() - idx != 1) break;
			
			num = num.substring(0, idx);
			cnt++;
		}
		
		bw.write(Integer.toString(cnt));
		bw.flush();

		br.close();
		bw.close();
	}
	
	static BigInteger factorial(BigInteger num) {
		if (num.equals(new BigInteger("0"))) return new BigInteger("1");
		
		return num.multiply(factorial(num.subtract(new BigInteger("1"))));
	}
}