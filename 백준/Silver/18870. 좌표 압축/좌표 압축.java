import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String input[] = br.readLine().split(" ");
		HashMap<Integer, Integer> map = new HashMap<>();
		
		
		for (int run = 0; run < n; run++) {
			arr[run] = Integer.parseInt(input[run]);
		}

		Arrays.sort(arr);
		
		int cnt = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], cnt);
				cnt++;
				
			}
		}
		
		for (int i = 0; i < input.length; i++) {
			bw.write(map.get(Integer.parseInt(input[i])) + " ");
		}

		bw.flush();

		br.close();
		bw.close();
	}
}

