import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n, m;
	static boolean card[] = new boolean[20_000_001];
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int run = 0; run < n; run++) {
			card[Integer.parseInt(st.nextToken()) + 10_000_000] = true;
		}
		
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int run = 0; run < m; run++) {
			if (card[Integer.parseInt(st.nextToken()) + 10_000_000]) bw.write("1 ");
			else bw.write("0 ");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}