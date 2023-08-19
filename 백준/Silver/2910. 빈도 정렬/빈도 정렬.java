import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Integer.parseInt(st.nextToken()); // c
		Map<Integer, Integer> map = new LinkedHashMap<>();
		
		st = new StringTokenizer(br.readLine());
		
		for (int run = 0; run < n; run++) {
			int num = Integer.parseInt(st.nextToken());
			
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		List<Integer> keyList = new ArrayList<Integer>(map.keySet());
		
		Collections.sort(keyList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o2) - map.get(o1);
			}
		});
		
		for (int i = 0; i < keyList.size(); i++) {
			int key = keyList.get(i);
			int r = map.get(key);
			
			while (r-- > 0) {
				bw.write(key + " ");
			}
		}
		
		br.close();
		bw.close();
	}
}