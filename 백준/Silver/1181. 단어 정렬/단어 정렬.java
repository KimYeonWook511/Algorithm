import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		String arr[] = new String[n]; 
		
		for (int run = 0; run < n; run++) {
			arr[run] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					for (int i = 0; i < o1.length(); i++) {
						if (o1.charAt(i) != o2.charAt(i)) return o1.charAt(i) - o2.charAt(i);
					}
					return 0;
					
				} else {
					return o1.length() - o2.length();
					
				}
			}
		});
		
		bw.write(arr[0] + "\n");
		for (int i = 1; i < arr.length; i++) {
			if (!arr[i].equals(arr[i - 1]))
				bw.write(arr[i] + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}