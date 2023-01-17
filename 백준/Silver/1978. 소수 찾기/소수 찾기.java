import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int primeNumberCnt = 0;
		
		for (int run = 0; run < n; run++) {
			int num = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			for (int i = 1; i <= num; i++) {
				if (num % i == 0) cnt++;
			}
			
			if (cnt == 2) primeNumberCnt++;
		}
		
		bw.write(Integer.toString(primeNumberCnt));
		bw.flush();

		br.close();
		bw.close();
	}
}