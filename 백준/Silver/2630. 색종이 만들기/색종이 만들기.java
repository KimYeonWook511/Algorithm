import java.io.*;
import java.util.*;

public class Main {
    static int N, wCnt = 0, bCnt = 0;
    static boolean arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < N; c++) {
                if (st.nextToken().equals("1")) arr[r][c] = true;
            }
        }

        func(0, 0, N, N);
        sb.append(wCnt).append("\n").append(bCnt);

        System.out.println(sb.toString());

        br.close();
    }

    static void func(int r1, int c1, int r2, int c2) {
        int pointR = (r2 + r1) / 2;
        int pointC = (c2 + c1) / 2;

        boolean flag = arr[r1][c1];

        for (int r = r1; r < r2; r++) {
            for (int c = c1; c < c2; c++) {
                if (arr[r][c] != flag) {
                    func(r1, c1, pointR, pointC);
                    func(r1, pointC, pointR, c2);
                    func(pointR, c1, r2, pointC);
                    func(pointR, pointC, r2, c2);
                    return;
                }
            }
        }

        if (arr[r1][c1]) bCnt++;
        else wCnt++;
    }
}