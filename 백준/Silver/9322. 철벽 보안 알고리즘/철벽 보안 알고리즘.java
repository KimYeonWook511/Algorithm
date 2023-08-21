import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringTokenizer text;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<String, Integer>(); 
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				map.put(st.nextToken(), i);
			}
			
			st = new StringTokenizer(br.readLine());
			text = new StringTokenizer(br.readLine());
			String result[] = new String[n];
			
			for (int i = 0; i < n; i++) {
				String word = st.nextToken();
				
				result[map.get(word)] = text.nextToken();
			}
			
			for (int i = 0; i < n; i++) {
				bw.write(result[i] + " ");
			}
			
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}