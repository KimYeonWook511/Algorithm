import java.io.*;

public class Main {
    static int N, arr[][], chk[][];
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        chk = new int[1 << N][N];

        for (int r = 0; r < N; r++) {
            String input = br.readLine();

            for (int c = 0; c < N; c++) {
                arr[r][c] = input.charAt(c) - '0';
            }

            for (int i = (1 << N) - 1; i >= 0; i--) {
                chk[i][r] = Integer.MAX_VALUE;
            }
        }

        func(0, 1 << 0, 1);

        System.out.println(result);

        br.close();
    }

    static void func(int idx, int bit, int cnt) {
        result = Math.max(result, cnt);

        for (int i = 1; i < N; i++) {
            if ((bit & (1 << i)) > 0) continue;
            if (chk[bit][idx] != Integer.MAX_VALUE && arr[idx][i] < chk[bit][idx]) continue;
            if (chk[bit | (1 << i)][i] <= arr[idx][i]) continue;
            
            chk[bit | (1 << i)][i] = arr[idx][i];
            func(i, bit | (1 << i), cnt + 1);
        }
    }
}