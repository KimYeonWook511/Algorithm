import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		long maxCnt = 0;
		long minValue = Long.MAX_VALUE;
		
		for (int run = 0; run < n; run++) {
			long num = Long.parseLong(br.readLine());
			
			if (map.containsKey(num)) map.put(num, map.get(num) + 1);
			else map.put(num, (long)1);
			
			if (map.get(num) > maxCnt) {
				maxCnt = map.get(num);
				minValue = num;
				
			} else if (map.get(num) == maxCnt) {
				minValue = Math.min(minValue, num);
			}
		}
		
		System.out.println(minValue);
		
		br.close();
	}
}