import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
		int arr[] = new int[10];
		int max = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			switch (c) {
			case '6': case '9':
				arr[6]++;
				max = Math.max(max, arr[6]);
				break;
			default:
				arr[c - '0'] += 2;
				max = Math.max(max, arr[c - '0']);
				break;
			}
		}
		
		System.out.println(max % 2 == 0 ? max / 2 : max / 2 + 1);

		br.close();
	}
}