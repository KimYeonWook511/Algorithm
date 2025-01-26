import java.io.*;

public class Main {
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            int len = input.length();

            int min[] = new int[2];
            int max[] = new int[2];
            int cur[] = new int[2];
            int d = 0;
            
            for (int i = 0; i < len; i++) {
                char ch = input.charAt(i);

                if (ch == 'F') {
                    cur[0] += dr[d];
                    cur[1] += dc[d];

                } else if (ch == 'B') {
                    cur[0] -= dr[d];
                    cur[1] -= dc[d];

                } else {
                    d = (d + (ch == 'L' ? 3 : 1)) % 4;
                }

                min[0] = Math.min(min[0], cur[0]);
                min[1] = Math.min(min[1], cur[1]);
                max[0] = Math.max(max[0], cur[0]);
                max[1] = Math.max(max[1], cur[1]);
            }

            sb.append((Math.abs(min[0]) + Math.abs(max[0])) * (Math.abs(min[1]) + Math.abs(max[1]))).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}