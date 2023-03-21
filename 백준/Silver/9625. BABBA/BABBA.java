import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int a = 1;
		int b = 0;
		
		for (int run = 0; run < n; run++) {
			int sum = a + b;
			
			a = b;
			b = sum;
		}
		
		bw.write(a + " " + b);
		bw.flush();

		br.close();
		bw.close();
	}
}