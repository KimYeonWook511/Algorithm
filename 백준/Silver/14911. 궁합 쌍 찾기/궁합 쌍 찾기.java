import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[10];
        int idx = 9;

        while (st.hasMoreElements()) {
            arr[idx--] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        Set<Long> set = new HashSet<>();
        int cnt = 0;

        for (int i = idx + 1; i < 10; i++) {
            for (int k = i + 1; k < 10; k++) {
                int sum = arr[i] + arr[k];

                if (sum < N) continue;
                if (sum > N) break;

                long val = arr[i] * 100_000 + arr[k];

                if (set.contains(val)) continue;

                set.add(val);
                sb.append(arr[i]).append(" ").append(arr[k]).append("\n");
                cnt++;
            }
        }
        
        sb.append(cnt);

        System.out.println(sb);

        br.close();
    }
}