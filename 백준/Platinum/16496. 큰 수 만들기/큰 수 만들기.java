import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String arr[] = new String[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int o1len = o1.length();
                int o2len = o2.length();
                int total = o1len + o2len;
                int val = 0;
                for (int i = 0; i < total; i++) {
                    char c1 = (i < o1len) ? o1.charAt(i) : o2.charAt(i - o1len); // a+b
                    char c2 = (i < o2len) ? o2.charAt(i) : o1.charAt(i - o2len); // b+a

                    if (c1 != c2) {
                        val = -Character.compare(c1, c2);
                        break;
                    }
                }
                return val;
            }
        });

        StringBuilder sb = new StringBuilder();
        if (arr[0].equals("0")) {
            sb.append("0");
        } else {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]);
            }
        }

        System.out.println(sb);

        br.close();
    }
}