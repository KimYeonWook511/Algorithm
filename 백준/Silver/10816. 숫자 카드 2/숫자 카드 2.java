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
	static HashMap<Integer, Integer> map = new HashMap<>();
	static boolean card[] = new boolean[20_000_001];
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int run = 0; run < n; run++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (map.containsKey(num)) map.put(num, map.get(num) + 1);
			else map.put(num, 1);
			
			card[num + 10_000_000] = true;
		}
		
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int run = 0; run < m; run++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (card[num + 10_000_000]) bw.write(map.get(num) + " ");
			else bw.write("0 ");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}