import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int n, m;
	static HashMap<String, Integer> map = new HashMap<>();
	static HashMap<String, Integer> resultMap = new HashMap<>();
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for (int run = 0; run < n; run++) {
			map.put(br.readLine(), null);
		}
		
		
		
		for (int run = 0; run < m; run++) {
			String line = br.readLine();
			
			if (map.containsKey(line)) {
				resultMap.put(line, null);
				map.remove(line);
				cnt++;
			}
		}
		
		bw.write(cnt + "\n");
		
		Object arr[] = resultMap.keySet().toArray();
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			bw.write(arr[i] + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}