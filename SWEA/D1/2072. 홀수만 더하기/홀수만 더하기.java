import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int sum = 0;

            for (int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());

                sum += num % 2 == 0 ? 0 : num;
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
	}
}