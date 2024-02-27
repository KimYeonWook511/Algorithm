import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int result[] = new int[3];
		int rgb[] = new int[3];
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 3; i++) {
				rgb[i] = Integer.parseInt(st.nextToken());
			}
			
			rgb[0] += Math.min(result[1], result[2]);
			rgb[1] += Math.min(result[0], result[2]);
			rgb[2] += Math.min(result[0], result[1]);
			
			result[0] = rgb[0];
			result[1] = rgb[1];
			result[2] = rgb[2];
		}

		System.out.println(Math.min(result[0], Math.min(result[1], result[2])));

		br.close();
	}
}