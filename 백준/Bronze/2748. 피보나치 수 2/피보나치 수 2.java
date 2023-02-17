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
		
		if (n == 1) bw.write("1");
		else bw.write(Long.toString(fibonacci(n)));
        
		bw.flush();

		br.close();
		bw.close();
	}
	
	static long fibonacci(int n) {
		long f[] = new long[n];
		f[0] = 1;
		f[1] = 1;
		
		for (int i = 2; i < n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		
		return f[n - 1];
	}
}