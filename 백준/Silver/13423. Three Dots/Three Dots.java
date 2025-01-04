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
            Set<Integer> set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                set.add(arr[i]);
            }

            Arrays.sort(arr);

            int result = 0;

            for (int i = 0; i < N - 2; i++) {
                for (int k = i + 2; k < N; k++) {
                    int sum = arr[i] + arr[k];

                    if (sum % 2 != 0) continue;
                    if (!set.contains(sum >> 1)) continue;

                    result++;
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}