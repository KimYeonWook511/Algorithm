import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Map<Long, Long> map = new HashMap<Long, Long>();
	static int p, q;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		map.put((long)0, (long)1); 
		
		System.out.println(sol(n));
		
		br.close();
	}
	
	public static long sol(long num) {
		if (!map.containsKey(num)) {
			map.put(num, sol(num / p) + sol(num / q));
		}
		
		return map.get(num);
	}
}