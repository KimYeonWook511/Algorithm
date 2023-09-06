import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<String> set = new HashSet<String>(); 
		
		for (int run = 0; run < t; run++) {
			String str = st.nextToken();
			
			if (str.length() < 6) continue;
			else if (str.substring(str.length() - 6).equals("Cheese")) set.add(str);
		}

		System.out.println(set.size() >= 4 ? "yummy" : "sad");
		
		br.close();
	}
}