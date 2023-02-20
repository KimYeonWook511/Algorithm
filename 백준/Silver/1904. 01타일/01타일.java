import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n + 1];
		arr[0] = 1;
		arr[1] = 1;
		
		if (n == 1) bw.write("1");
		else bw.write(Integer.toString(dp(n, arr)));
		bw.flush();

		br.close();
		bw.close();
	}
	
	static int dp(int n, int arr[]) {
		for (int i = 2; i <= n; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
		}
		
		return arr[n];
	}
}