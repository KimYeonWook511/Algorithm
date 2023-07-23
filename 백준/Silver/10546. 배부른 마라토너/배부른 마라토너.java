import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (int run = 0; run < n; run++) {
			String str = br.readLine();
			
			if (map.containsKey(str)) map.put(str, map.get(str) + 1);
			else map.put(str, 1);
		}
		
		for (int run = 1; run < n; run++) {
			String str = br.readLine();
			int cnt = map.get(str);
			
			if (cnt == 1) map.remove(str);
			else map.put(str, cnt - 1);
		}
		
		System.out.println(map.keySet().toArray()[0]);

		br.close();
	}
}