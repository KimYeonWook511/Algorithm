import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String arr[] = new String[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		int k = arr[0].length();
		
		for (int len = 1; len < k; len++) {
			HashSet<String> set = new HashSet<String>();
			
			for (int i = 0; i < n; i++) {
				set.add(arr[i].substring(k - len, k));
			}
			
			if (set.size() == n) k = len;
		}
		
		System.out.println(k);
		
		br.close();
	}
}