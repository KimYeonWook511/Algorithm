import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<>();
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			
			if (!map.containsKey(site)) map.put(site, st.nextToken());
		}
		
		for (int run = 0; run < m; run++) {
			bw.write(map.get(br.readLine()) + "\n");
		}
		
		br.close();
		bw.close();
	}
}