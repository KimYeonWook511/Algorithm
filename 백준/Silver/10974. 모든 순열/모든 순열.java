import java.io.*;

public class Main {
    static int n;
    static boolean chk[];
    static int arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        chk = new boolean[n];
        arr = new int[n];

        func(0);

        System.out.println(sb.toString());

        br.close();
    }

    public static void func(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }

            sb.append("\n");

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!chk[i]) {
                arr[depth] = i + 1;
                chk[i] = true;
                func(depth + 1);
                chk[i] = false;
            }
        }
    }
}