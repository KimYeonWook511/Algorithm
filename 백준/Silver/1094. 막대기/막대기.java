import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int x = Integer.parseInt(br.readLine());
		int cm = 64;
		int cnt = 0;
		
		while (cm > 0) {
			if (cm > x) cm /= 2;
			else {
				x -= cm;
				cnt++;
			}
		}
		
		System.out.println(cnt);

		br.close();
	}
}