import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int l = -Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		
		int point = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			
			map.put(st.nextToken(), st.nextToken().equals("W") ? w : l);
		}

		for (int run = 0; run < n; run++) {
			String player = br.readLine();
			
			point += map.getOrDefault(player, l);
			
			if (point < 0) point = 0;
			else if (point >= g) break;
		}
		
		System.out.println(point >= g ? "I AM NOT IRONMAN!!" : "I AM IRONMAN!!");
		
		br.close();
	}
}