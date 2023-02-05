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
		int t = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < t; run++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			
			while (n-- > 0) {
				st = new StringTokenizer(br.readLine());
				st.nextToken(); // name
				String type = st.nextToken();
				
				if (map.containsKey(type)) {
					map.put(type, map.get(type) + 1);
					
				} else {
					map.put(type, 1);
					
				}
			}
			
			Object arr[] = map.values().toArray();
			int result = 1;
			 
			for (int i = 0; i < arr.length; i++) {
				result *= Integer.parseInt(arr[i].toString()) + 1;
			}
			
			bw.write(result - 1 + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}