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
		int cycle = 0;
		int originalN = n;
		
		if (n < 10) { 
			n = n * 11;
			cycle += 1;
			
		} 
		
		while (n != 0) {
			cycle += 1;
			
			n = n % 10 * 10 + (n / 10 + n % 10) % 10;
			
			if (n == originalN) {
				break;
			}
		}
		
		bw.write(Integer.toString(cycle));
		bw.flush();

		br.close();
		bw.close();
	}
}
