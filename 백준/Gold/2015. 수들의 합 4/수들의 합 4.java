import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Map<Integer, Long> map = new HashMap<>();
        int sum = 0;
		long cnt = 0;

        map.put(0, 1L);

		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
            sum += Integer.parseInt(st.nextToken());

            cnt += map.getOrDefault(sum - K, 0L);

            map.put(sum, map.getOrDefault(sum, 0L) + 1);
		}
		
        System.out.println(cnt);
		
		br.close();
	}
}