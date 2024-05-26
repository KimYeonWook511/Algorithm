import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
        int len = n;

		long arr[] = new long[n];
		String str = "";
        int strLen = 0;
        String rev = "";


		while (true) {
			while (st.hasMoreTokens()) {
                n--;
				str = st.nextToken();
                strLen = str.length();
				rev = "";

				for (int i = strLen - 1; i >= 0; i--) {
					rev += str.charAt(i);
				}

				arr[n] = Long.parseLong(rev);
			}

            if (n == 0) break;

			st =  new StringTokenizer(br.readLine());
		}

		Arrays.sort(arr);
        
		for(int i = 0; i < len; i++) {
			sb.append(arr[i]).append("\n");
		}

        System.out.println(sb);

        br.close();
	}
}