import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		float total = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		String work[] = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};
		
		while (true) {
			String str = br.readLine();
			
			if (str == null || str.length() == 0) break;
			
			StringTokenizer st = new StringTokenizer(str);
			
			while (st.hasMoreTokens()) {
				String w = st.nextToken();
				
				map.put(w, map.getOrDefault(w, 0) + 1);
				total++;
			}
		}
		
		for (int i = 0; i < work.length; i++) {
			String k = work[i];
			int v = map.getOrDefault(k, 0);
			
			sb.append(k).append(" ").append(v).append(" ").append(String.format("%.2f", v / total)).append("\n");
		}
		
		sb.append("Total ").append((int)total).append(" 1.00");
		
		System.out.println(sb.toString());
		
		br.close();
	}
}