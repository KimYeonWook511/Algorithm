import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> coinList = new ArrayList<>();
		int dp[] = new int[k + 1];
		
		for (int i = 0; i < n; i++) {
			int coin = Integer.parseInt(br.readLine());
			
			if (coin <= k && !coinList.contains(coin)) coinList.add(coin);
		}

		coinList.sort(null);
		
		for (int c = 1; c <= k; c++) {
			dp[c] = 10001; // 초기화 과정
		}
		
		for (int i = 0; i < coinList.size(); i++) {
			int coin = coinList.get(i);
			
			for (int c = 1; c <= k; c++) {
				if (c == coin) dp[c] = 1;
				
				if (c > coin) {
					int val = dp[c - coin];
					
					if (val != 10001) {
						dp[c] = Math.min(dp[c], val + 1); 
					}
				}
			}
		}
		
		
		bw.write(Integer.toString(dp[k] == 10001 ? -1 : dp[k]));
		bw.flush();

		br.close();
		bw.close();
	}
}