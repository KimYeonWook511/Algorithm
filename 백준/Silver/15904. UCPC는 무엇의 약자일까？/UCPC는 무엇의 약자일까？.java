import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
		char arr[] = {'U', 'C', 'P', 'C'};
		int idx = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == arr[idx] && ++idx > 3) {
				break;
			}
		}

		System.out.println(idx > 3 ? "I love UCPC" : "I hate UCPC");
		
		br.close();
	}
}