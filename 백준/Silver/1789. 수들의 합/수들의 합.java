import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		long s = Long.parseLong(br.readLine());
		long i = 0;
		
		while (i++ >= 0) {
			if (i * (i + 3) / 2 >= s) break;
		}

		System.out.println(i);
		
		br.close();
	}
}