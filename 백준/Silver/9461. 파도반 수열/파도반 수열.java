import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			int n = Integer.parseInt(br.readLine());
			long arr[] = new long[n + 5];
			
			for (int i = 0; i <= 2; i++) {
				arr[i] = 1;
			}
			
			for (int i = 3; i <= 4; i++) {
				arr[i] = 2;
			}
			
			for (int i = 5; i < n; i++) {
				arr[i] = arr[i - 1] + arr[i - 5];
			}
			
			bw.write(arr[n - 1] + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}