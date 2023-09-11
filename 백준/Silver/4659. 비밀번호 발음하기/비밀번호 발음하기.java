import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String str = br.readLine();
			
			if (str.equals("end")) break;
			
			boolean flag[] = {false, true};
			int cnt[] = new int[2];
			
			char c = str.charAt(0);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				flag[0] = true;
				cnt[0]++;
				
			} else {
				cnt[1]++;
			}
			
			if (str.length() > 1) {
				c = str.charAt(1);
				
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					flag[0] = true;
					cnt[1] = 0;
					cnt[0]++;
					
				} else {
					cnt[0] = 0;
					cnt[1]++;
				}
				
				if (c == str.charAt(0) && c != 'e' && c != 'o') {
					flag[1] = false;
				}
			}
			
			for (int i = 2; i < str.length(); i++) {
				c = str.charAt(i);
				
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					flag[0] = true;
					cnt[1] = 0;
					cnt[0]++;
					
				} else {
					cnt[0] = 0;
					cnt[1]++;
				}
				
				if (cnt[0] > 2 || cnt[1] > 2) {
					flag[1] = false;
					break;
				}
				
				if (c == str.charAt(i - 1) && c != 'e' && c != 'o') {
					flag[1] = false;
					break;	
				}
			}
			
			sb.append("<").append(str).append("> is ").append(flag[0] && flag[1]? "acceptable.\n" : "not acceptable.\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}