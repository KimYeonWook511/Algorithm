import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		Set<String> set = new HashSet<String>(); 
		
		for (int run = 0; run < n; run++) {
			set.add(br.readLine());
		}
		
		if (game.equals("Y")) System.out.println(set.size());
		else if (game.equals("F")) System.out.println(set.size() / 2);
		else System.out.println(set.size() / 3);
		
		br.close();
	}
}