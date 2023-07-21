import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<String>();
		int cnt = 0;
		
		for (int run = 0; run < n; run++) {
			String str = br.readLine();
			
			if (str.equals("ENTER")) {
				cnt += set.size();
				set = new HashSet<String>();
				
			} else {
				set.add(str);
			}
		}
		
		System.out.println(cnt + set.size());
		
		br.close();
	}
}