import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n, m;
	static ArrayList<String> list = new ArrayList<String>();
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for (int run = 0; run < n; run++) {
			list.add(br.readLine());
		}
		
		for (int run = 0; run < m; run++) {
			if (list.contains(br.readLine())) cnt++;
		}
		
		bw.write(Integer.toString(cnt));
		bw.flush();

		br.close();
		bw.close();
	}
}