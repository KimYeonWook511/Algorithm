import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		String pattern = br.readLine();
		
		int pLen = pattern.length();
		int p[] = new int[pLen];
		int l = 0;
		
		for (int r = 1; r < pLen; r++) {
			while (l > 0 && pattern.charAt(l) != pattern.charAt(r)) {
				l = p[l - 1];
			}
			
			if (pattern.charAt(l) == pattern.charAt(r)) p[r] = ++l;
		}

		int strLen = str.length();
		int j = 0;
		int cnt = 0;
		
		for (int i = 0; i < strLen; i++) {
			while (j > 0 && str.charAt(i) != pattern.charAt(j)) {
				j = p[j - 1];
			}
			
			if (str.charAt(i) == pattern.charAt(j)) {
				if (++j == pLen) {
					sb.append(i - pLen + 2).append(" ");
					j = p[j - 1];
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(sb);
		
		br.close();
	}
}