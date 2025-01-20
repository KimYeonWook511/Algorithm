import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[50_001];
		int max = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			max = Math.max(max, ++arr[Integer.parseInt(st.nextToken())]);
		}		
		
		System.out.println(max);

		br.close();
	}
}