import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (int run = 0; run < n; run++) {
			String extension = br.readLine().split("[.]")[1];
			
			if (map.containsKey(extension)) map.put(extension, map.get(extension) + 1);
			else map.put(extension, 1);
		}
		
		Object arr[] = map.keySet().toArray();
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			bw.write(arr[i] + " " + map.get(arr[i]) + "\n");
		}
		
		br.close();
		bw.close();
	}
}