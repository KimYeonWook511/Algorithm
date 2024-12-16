import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String arr[] = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -Integer.compare(o1.length(), o2.length());
            }
        });

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            boolean flag = false;

            for (int k = 0; k < i; k++) {
                if (!arr[k].startsWith(arr[i])) continue;

                flag = true;
                break;
            }

            if (!flag) cnt++;
        }

        System.out.println(cnt);

        br.close();
    }
}