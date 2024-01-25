import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<>();
		
		for (int run = 0; run < N; run++) {
			String str = br.readLine();
			int len = str.length();
			boolean flag = false;
			
			for (int i = 0; i < len; i++) {
				if (set.contains(str.substring(i, len) + str.substring(0, i))) {
					flag = true;
					break;
				}
			}
			
			if (!flag) set.add(str); 
		}
		
		System.out.println(set.size());
		
		br.close();
	}
}
