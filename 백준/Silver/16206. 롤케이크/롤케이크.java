import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> cakes1 = new ArrayList<>();
        List<Integer> cakes2 = new ArrayList<>();
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (x == 10) {
                answer++;
            } else if (x > 10) {
                if (x % 10 == 0) cakes1.add(x);
                else cakes2.add(x);
            }
        }

        Collections.sort(cakes1);

        for (int cake : cakes1) {
            int piece = cake / 10;

            if (M >= piece - 1) {
                answer += piece;
                M -= piece - 1;
            } else {
                answer += M;
                M = 0;
                break;
            }
        }

        for (int x : cakes2) {
            int piece = x / 10;

            if (M >= piece) {
                answer += piece;
                M -= piece;
            } else {
                answer += M;
                break;
            }
        }

        System.out.println(answer);

        br.close();
    }
}