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

		int x = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			sum += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
		}
		
		if (sum == x) bw.write("Yes");
		else bw.write("No");
		
		bw.flush();

		br.close();
		bw.close();
	}
}
