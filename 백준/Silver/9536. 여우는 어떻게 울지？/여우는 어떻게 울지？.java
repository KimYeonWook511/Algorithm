import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int run = 0; run < T; run++) {
			Set<String> set = new HashSet<>(); 
			Deque<String> deque = new LinkedList<>(); 
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while (st.hasMoreTokens()) {
				String sound = st.nextToken();
				
				set.add(sound);
				deque.offerLast(sound);
			}
			
			while (true) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				
				if (st.nextToken().equals("does")) break;
				
				set.remove(st.nextToken());
			}

			while (!deque.isEmpty()) {
				String str = deque.pollFirst();
				
				if (set.contains(str)) sb.append(str).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}