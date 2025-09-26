import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String arr[] = new String[N];
        Map<String, Integer> map = new HashMap<>();

        int maxLength = 0;
        int S = 0;
        int T = 1;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = str;

            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < str.length(); k++) {
                sb.append(str.charAt(k));

                Integer val = map.get(sb.toString());
                if (val == null) {
                    map.put(sb.toString(), i);
                    continue;
                }

                if (k + 1 > maxLength) {
                    maxLength = k + 1;
                    S = val;
                    T = i;
                } else if (k + 1 == maxLength && val < S) {
                    S = val;
                    T = i;
                }
            }
        }

        System.out.println(arr[S] + "\n" + arr[T]);

        br.close();
    }
}