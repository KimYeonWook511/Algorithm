import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<String, Integer>();
		String result = br.readLine();
		map.put(result, 1);
		int max = 1;
		
		for (int run = 1; run < n; run++) {
			String book = br.readLine();
			
			if (map.containsKey(book)) map.put(book , map.get(book) + 1);
			else map.put(book, 1);
			
			int cnt = map.get(book);
			
			if (cnt == max && book.compareTo(result) <= 0) {
				result = book;
				
			} else if (cnt > max) {
				max = cnt;
				result = book;  
			}
		}
		
		System.out.println(result);
		
		br.close();
	}
}