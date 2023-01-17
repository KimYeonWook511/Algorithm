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
		int copyN = n;
		int max = n / 3;
		int cnt = -1;
		
		for (int i = 0; i <= max; i++) {
			n = copyN;
			n = n - 3 * i;
			
			if (n % 5 == 0) {
				cnt = i + n / 5;
				break;
			}
		}
		
		bw.write(Integer.toString(cnt));
		bw.flush();

		br.close();
		bw.close();
	}
}