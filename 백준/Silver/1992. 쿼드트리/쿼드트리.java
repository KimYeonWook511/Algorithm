import java.io.*;

public class Main {
    static int arr[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        func(0, 0, N);

        System.out.println(sb);

        br.close();
    }

    static void func(int r, int c, int size) {
        if (check(r, c, size)) {
            sb.append(arr[r][c]);
            return;
        }

        int half = size / 2;
        sb.append("(");
        // 좌상
        func(r, c, half);
        // 우상
        func(r, c + half, half);
        // 좌하
        func(r + half, c, half);
        // 우하
        func(r + half, c + half, half);
        sb.append(")");
    }

    static boolean check(int r, int c, int size) {
        for (int nr = r; nr < r + size; nr++) {
            for (int nc = c; nc < c + size; nc++) {
                if (arr[nr][nc] != arr[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
