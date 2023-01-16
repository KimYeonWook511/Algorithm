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
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			st.nextToken(); // w
			int n = Integer.parseInt(st.nextToken());
			
			String y, x;
			
			if (n % h == 0) {
				y = Integer.toString(h);
				x = Integer.toString(n / h);
				
			} else {
				y = Integer.toString(n % h);
				x = Integer.toString(n / h + 1);
				
			}

			if (x.length() == 1) {
				x = "0" + x;
			}
			
			bw.write(y + x + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}