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
	static int n, m;
	static HashMap<String, Integer> map = new HashMap<>();
	static String arr[];
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new String[n];
		
		for (int run = 0; run < n; run++) {
			String line = br.readLine();
			map.put(line, run + 1);
			arr[run] = line;
		}
		
		for (int run = 0; run < m; run++) {
			String line = br.readLine();
			if (line.charAt(0) < 65) bw.write(arr[Integer.parseInt(line) - 1] + "\n");
			else bw.write(map.get(line) + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}