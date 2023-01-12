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

		int c = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < c; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int grade[] = new int[n]; 
			int total = 0;
			
			for (int i = 0; i < n; i++) {
				grade[i] = Integer.parseInt(st.nextToken());
				total += grade[i];
			}
			
			int cnt = 0;
			
			for (int i = 0; i < n; i++) {
				if (grade[i] > (double)total / n) cnt++; 
			}
			
			bw.write(String.format("%2.3f", (double)cnt / n * 100) + "%\n");
		}

		bw.flush();

		br.close();
		bw.close();
	}
}