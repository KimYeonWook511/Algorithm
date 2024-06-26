import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char arr[] = new char[N];
        int topIdx = -1;

        String str = br.readLine();
        char num = 0;

        for (int i = 0; i < N; i++) {
            num = str.charAt(i);

            while (topIdx >= 0) {
                if (K == 0) break;
                if (num <= arr[topIdx]) break;

                topIdx--;
                K--;
            }

            arr[++topIdx] = num;
        }

        for (int i = topIdx - K; i >= 0; i--) {
            sb.append(arr[i]);
        }

        System.out.println(sb.reverse());

        br.close();
    }
}