import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<Integer>();
		st = new StringTokenizer(br.readLine());
		
		for (int run = 0; run < n; run++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int run = 0; run < m; run++) {
			bw.write(set.contains(Integer.parseInt(st.nextToken())) ? "1\n" : "0\n");
		}

		br.close();
		bw.close();
	}
}