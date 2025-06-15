import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int cnt[] = new int[6];
		cnt[0] = Integer.MAX_VALUE;
		
		int result = -1;
		if (str.length() % 5 == 0) {
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				
				int idx = 0;
				if (ch == 'q') idx = 1;
				else if (ch == 'u') idx = 2;
				else if (ch == 'a') idx = 3;
				else if (ch == 'c') idx = 4;
				else idx = 5;

				cnt[idx]++;
				
				if (cnt[idx - 1] < cnt[idx]) {
					result = -1;
					break;
				}
				
				result = Math.max(result, cnt[1] - cnt[5]);
			}

		}

		System.out.println(cnt[5] * 5 == str.length() ? result : "-1");

		br.close();
	}
}