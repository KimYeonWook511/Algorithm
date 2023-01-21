import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(Integer.toString(factorial(Integer.parseInt(br.readLine()))));
		
		bw.flush();

		br.close();
		bw.close();
	}
	
	static int factorial(int n) {
		if (n < 1) return 1;
		
		return n * factorial(n - 1);
	}
}