import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		
		for (int run = 0; run < n; run++) {
			char arr[] = br.readLine().toCharArray();
			
			Arrays.sort(arr);
			
			set.add(Arrays.toString(arr));
		}
		
		System.out.println(set.size());
		
		br.close();
	}
}
