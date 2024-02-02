import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int n = Integer.parseInt(br.readLine());
		int p = 0;
		
		for (int i = 0; (1 << i) < n; i++) {
			p++;
		}

		System.out.println((n << 1) - (1 << p));
		
		br.close();
	}
}