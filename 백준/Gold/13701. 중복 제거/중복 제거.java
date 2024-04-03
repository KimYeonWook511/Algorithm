import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int chk[] = new int[(2 << 25) / 32];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			
			int idx = num / 32;
			int bit = num % 32;
			
			if ((chk[idx] & (1 << bit)) == 0) {
				chk[idx] |= 1 << bit;
				sb.append(num).append(" ");
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}
}