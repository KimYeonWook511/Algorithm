import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>(); 
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			
			if (st.nextToken().equals("enter")) set.add(name);
			else set.remove(name);
		}
		
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());
		
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + "\n");
		}
		
		br.close();
		bw.close();
	}
}