import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        
        for (int run = 0; run < t; run++) {
            Set<Integer> set = new HashSet<>();
            
            int n = Integer.parseInt(br.readLine());
            int a[] = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            int b[] = new int[m];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int k = Integer.parseInt(br.readLine());
            int c[] = new int[k];
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < k; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }

            for (int ai = 0; ai < n; ai++) {
                for (int bi = 0; bi < m; bi++) {
                    for (int ci = 0; ci < k; ci++) {
                        int sum = a[ai] + b[bi] + c[ci];

                        while (true) {
                            if (sum % 10 != 5 && sum % 10 != 8) break;

                            sum /= 10;

                            if (sum == 0) {
                                set.add(a[ai] + b[bi] + c[ci]);
                                break;
                            }
                        }
                    }
                }
            }

            sb.append(set.size()).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}