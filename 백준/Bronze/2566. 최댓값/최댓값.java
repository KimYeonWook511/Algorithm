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
		
		StringTokenizer st;
		int max = 0;
		String rc = "1 1";
		
		for (int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int k = 1; k <= 9; k++) {
				int num = Integer.parseInt(st.nextToken());
				
				if (num > max) {
					max = num;
					rc = i + " " + k;
				}
			}
		}
		
		bw.write(max + "\n");
		bw.write(rc);
		bw.flush();

		br.close();
		bw.close();
	}
}
