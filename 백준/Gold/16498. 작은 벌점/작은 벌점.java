import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int first[] = new int[A];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            first[i] = Integer.parseInt(st.nextToken());
        }

        int second[] = new int[B];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            second[i] = Integer.parseInt(st.nextToken());
        }

        int third[] = new int[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            third[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(first);
        Arrays.sort(second);
        Arrays.sort(third);

        int a = 0;
        int b = 0;
        int c = 0;
        int answer = Integer.MAX_VALUE;
        while (a < A && b < B && c < C) {
            int max = Math.max(first[a], Math.max(second[b], third[c]));
            int min = Math.min(first[a], Math.min(second[b], third[c]));

            answer = Math.min(answer, max - min);

            if (min == first[a]) {
                a++;
            } else if (min == second[b]) {
                b++;
            } else {
                c++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}