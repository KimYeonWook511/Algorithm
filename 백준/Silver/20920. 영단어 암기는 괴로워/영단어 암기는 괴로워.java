import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		
		for (int run = 0; run < n; run++) {
			String str = br.readLine();
			
			if (str.length() >= m) map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		Iterator<String> key = map.keySet().iterator();
		List<String> list = new ArrayList<String>();
		
		while (key.hasNext()) {
			list.add(key.next());
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int v1 = map.get(o1);
				int v2 = map.get(o2);
				
				if (v1 != v2) return v2 - v1;
				else if (o1.length() == o2.length()) return o1.compareTo(o2);
				else return o2.length() - o1.length();
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + "\n");
		}
		
		br.close();
		bw.close();
	}
}