import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[10_001];
		
		for (int run = 0; run < n; run++) {
			int num = Integer.parseInt(br.readLine());
			
			arr[num]++;
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int run = 1; run <= arr[i]; run++) {
				bw.write(i + "\n");
			}
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}
