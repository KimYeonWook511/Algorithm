import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

        	int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			N = (1 << N) - 1;

            sb.append("#").append(t).append(" ").append(N == (M & N) ? "ON" : "OFF").append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}