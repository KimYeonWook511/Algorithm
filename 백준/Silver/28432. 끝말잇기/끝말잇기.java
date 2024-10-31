import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String arr[] = new String[N];
        Set<String> set = new HashSet<>();
        int idx = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (str.equals("?")) {
                idx = i;
            }

            arr[i] = str;
            set.add(str);
        }
        
        int M = Integer.parseInt(br.readLine());
        String result = "";
        
        if (N == 1) {
            result = br.readLine();
            M = 0;
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            if (set.contains(str)) continue;

            if (idx == 0) {
                if (str.charAt(str.length() - 1) != arr[idx + 1].charAt(0)) continue;

            } else if (idx == N -1) {
                if (arr[idx - 1].charAt(arr[idx - 1].length() - 1) != str.charAt(0)) continue;

            } else {
                if (arr[idx - 1].charAt(arr[idx - 1].length() - 1) != str.charAt(0)) continue;
                if (str.charAt(str.length() - 1) != arr[idx + 1].charAt(0)) continue;
            }

            result = str;
        }

        System.out.println(result);

        br.close();
    }
}