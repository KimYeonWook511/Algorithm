import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		String dic[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		Map<String, String> map = new HashMap<>();
		
		for (int i = m; i <= n; i++) {
			String num = Integer.toString(i);
			
			if (num.length() == 1) {
				// 1 ~ 9
				map.put(num, dic[i]);
				
			} else {
				// 10~ 99
				map.put(num, dic[num.charAt(0) - '0'] + " " + dic[num.charAt(1) - '0']);
			}
		}
		
		List<String> list = new ArrayList<>(map.keySet());
		
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return map.get(o1).compareTo(map.get(o2));
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + " ");
			
			if ((i + 1) % 10 == 0) bw.newLine();
		}
		
		br.close();
		bw.close();
	}
}