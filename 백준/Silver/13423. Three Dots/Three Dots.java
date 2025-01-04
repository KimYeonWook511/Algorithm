import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int result = 0;

            for (int i = 1; i < N - 1; i++) {
                int l = 0;
                int r = N - 1;
                int val = arr[i] << 1;

                while (l < i && r > i) {
                    int sum = arr[l] + arr[r];

                    if (sum < val) l++;
                    else if (sum > val) r--;
                    else {
                        result++;
                        l++;
                        r--;
                    }
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}