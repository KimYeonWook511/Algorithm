import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
       
        int K = Integer.parseInt(br.readLine());
        int val = N / K;

        for (int i = 0; i < N; i += val) {
            func(i, val + i);
        }

        System.out.println(sb);

        br.close();
    }

    static void func(int s, int e) {
        int len = e - s;
        int temp[] = new int[len];

        for (int i = s; i < e; i++) {
            temp[i - s] = arr[i];
        }

        Arrays.sort(temp);

        for (int i = 0; i < len; i++) {
            sb.append(temp[i]).append(" ");
        }
    }
}