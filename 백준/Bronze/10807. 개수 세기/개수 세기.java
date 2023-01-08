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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(st.nextToken()) == v) cnt++;
		}
	
		bw.write(Integer.toString(cnt));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
