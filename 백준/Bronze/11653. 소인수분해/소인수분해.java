import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		while (n != 1) {
			for (int i = 2; i <= n; i++) {
				if (n % i == 0) {
					bw.write(i + "\n");
					n /= i;
					break;
				}
			}
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}