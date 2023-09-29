import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt[] = {0, 0};

        boolean arr[][] = new boolean[n + 2][n + 2];

        for (int r = 1; r <= n; r++) {
            String line = br.readLine();

            for (int c = 1; c <= n; c++) {
                char room = line.charAt(c - 1);

                if (room == '.') arr[r][c] = true;
            }

            for (int c = 3; c <= n + 1; c++) {
                if (!arr[r][c] && arr[r][c - 2] && arr[r][c - 1]) cnt[0]++;
            }
        }

        for (int r = 3; r <= n + 1; r++) {
            for (int c = 1; c <= n; c++) {
                if (!arr[r][c] && arr[r - 2][c] && arr[r - 1][c]) cnt[1]++;
            }
        }        

        System.out.println(cnt[0] + " " + cnt[1]);

        br.close();
    }
}