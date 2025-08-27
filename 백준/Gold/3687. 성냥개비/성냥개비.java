import java.io.*;

public class Main {
    static final int COUNT[] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String minimumDP[] = new String[101];
        minimumDP[2] = "1";
        minimumDP[3] = "7";
        minimumDP[4] = "4";
        minimumDP[5] = "2";
        minimumDP[6] = "6";
        minimumDP[7] = "8";
        minimumDP[8] = "10";
        for (int i = 9; i <= 100; i++) {
            minimumDP[i] = minimumDP[i - COUNT[0]] + 0;

            for (int k = 1; k <= 9; k++) {
                String cur = minimumDP[i - COUNT[k]] + k;

                if (minimumDP[i].length() > cur.length()) minimumDP[i] = cur;
                else if (minimumDP[i].length() == cur.length() && minimumDP[i].compareTo(cur) > 0) minimumDP[i] = cur;
            }   
        }

        String maximumDP[] = new String[101];
        maximumDP[2] = "1";
        maximumDP[3] = "7";
        for (int i = 4; i <= 100; i++) {
            maximumDP[i] = maximumDP[i - 2] + maximumDP[2];
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(minimumDP[n]).append(" ").append(maximumDP[n]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}