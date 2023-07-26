import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		LinkedHashSet<String> set = new LinkedHashSet<>(); 
		
		for (int run = 0; run < l; run++) {
			String str = br.readLine();
			
			if (set.contains(str)) set.remove(str);
			
			set.add(str);
		}
		
		Iterator<String> iter = set.iterator();
		
		while (iter.hasNext() && k-- > 0) {
			bw.write(iter.next() + "\n");
		}
		
		br.close();
		bw.close();
	}
}