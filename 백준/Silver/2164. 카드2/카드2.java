import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		int p = 0;
		
		for (int i = 0; Math.pow(2, i) < n; i++) {
			p++;
		}
		
		System.out.println(2 * n - (int)Math.pow(2, p));
		
		br.close();
	}
}