import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static final int M = 1_000_000;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		boolean arr[] = new boolean[2_000_001];
		
		for (int run = 0; run < n; run++) {
			int num = Integer.parseInt(br.readLine());
			
			arr[num + M] = true;
		}
		
		for (int i = 2_000_000; i >= 0; i--) {
			if (arr[i]) bw.write(i - M + "\n");
		}
		
		br.close();
		bw.close();
	}
}
