import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.parseInt(br.readLine());
		int tot = 2;
		int cnt = 1;
		
		while (x > 1) {
			x -= tot;
			
			tot++;
		}
		
		for (int i = x; i < 1; i++) {
			cnt++;
		}
		
		if (tot % 2 == 0) {
			bw.write(cnt + "/" + (tot - cnt));
			
		} else {
			bw.write((tot - cnt) + "/" + cnt);
			
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}