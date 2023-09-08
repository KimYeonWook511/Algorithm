import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int arr[] = new int[2];
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			char c = str.charAt(i);
			
			if (c >= '1' && c <= '9') {
				cnt++;
				
			} else if (c == 'L') {
				arr[0]++;
				
			} else if (c == 'S') {
				arr[1]++;
				
			} else if (c == 'R') {
				if (arr[0] == 0) break;
				
				arr[0]--;
				cnt++;
				
			} else {
				if (arr[1] == 0) break;
				
				arr[1]--;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		br.close();
	}
}