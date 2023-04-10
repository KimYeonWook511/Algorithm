import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();
		int dp[][][] = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1];
		
		for (int x = 1; x <= str1.length(); x++) {
			for (int y = 1; y <= str2.length(); y++) {
				for (int z = 1; z <= str3.length(); z++) {
					if (str1.charAt(x - 1) == str2.charAt(y - 1) && str2.charAt(y - 1) == str3.charAt(z - 1)) dp[x][y][z] = dp[x - 1][y - 1][z - 1] + 1;
					else dp[x][y][z] = Math.max(dp[x - 1][y][z], Math.max(dp[x][y - 1][z], dp[x][y][z - 1])); 
				}
			}
		}
		
		bw.write(Integer.toString(dp[str1.length()][str2.length()][str3.length()]));
		bw.flush();

		br.close();
		bw.close();
	}
}