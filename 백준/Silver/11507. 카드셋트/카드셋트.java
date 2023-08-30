import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		boolean card[][] = new boolean[4][13];
		boolean flag = false;
		int cnt[] = {13, 13, 13, 13};
		
		for (int i = 0; i * 3 < str.length(); i++) {
			char c = str.charAt(i * 3);
			int num = Integer.parseInt(str.substring(i * 3 + 1, i * 3 + 3));
			
			if (c == 'P') {
				if (card[0][num - 1]) {
					flag = true;
					break;
				}
				
				card[0][num - 1] = true;
				cnt[0]--;
				
			} else if (c == 'K') {
				if (card[1][num - 1]) {
					flag = true;
					break;
				}
				
				card[1][num - 1] = true;
				cnt[1]--;
				
			} else if (c == 'H') { 
				if (card[2][num - 1]) {
					flag = true;
					break;
				}
				
				card[2][num - 1] = true;
				cnt[2]--;
				
			} else { // c == 'T'
				if (card[3][num - 1]) {
					flag = true;
					break;
				}
				
				card[3][num - 1] = true;
				cnt[3]--;
			}
		}
		
		if (flag) sb.append("GRESKA");
		else sb.append(cnt[0] + " " + cnt[1] + " " + cnt[2] + " " + cnt[3]);
		
		System.out.println(sb.toString());
		
		br.close();
	}
}