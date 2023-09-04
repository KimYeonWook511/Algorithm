import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[2][2];
		int time = 0;
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			
			int team = Integer.parseInt(st.nextToken()) - 1;
			int revTeam = (team + 1) % 2;
			String mmss[] = st.nextToken().split(":");
			
			int t = Integer.parseInt(mmss[0]) * 60 + Integer.parseInt(mmss[1]);
			int cal = arr[team][0] - arr[revTeam][0];
			
			
			if (cal == -1) {
				arr[revTeam][1] += t - time;
				time = t;
				
			} else if (cal == 0) {
				time = t;
			}
			
			arr[team][0]++;
		}
		
		if (arr[0][0] > arr[1][0]) arr[0][1] += 48 * 60 - time;
		else if (arr[0][0] < arr[1][0]) arr[1][1] += 48 * 60 - time;
		
		sb.append(String.format("%02d", arr[0][1] / 60)).append(":").append(String.format("%02d", arr[0][1] % 60)).append("\n");
		sb.append(String.format("%02d", arr[1][1] / 60)).append(":").append(String.format("%02d", arr[1][1] % 60));
		
		System.out.println(sb.toString());
		
		br.close();
	}
}