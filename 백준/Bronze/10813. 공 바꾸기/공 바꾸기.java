import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int bucket[] = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			bucket[i] = i;
		}
		
		for (int run = 0; run < m; run++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int temp = bucket[i];
			
			bucket[i] = bucket[j];
			bucket[j] = temp;
		}
		
		for (int i = 1; i <= n; i++) {
			bw.write(bucket[i] + " ");
		}
		
		br.close();
		bw.close();
	}
}
