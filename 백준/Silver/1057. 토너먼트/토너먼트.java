import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer.parseInt(st.nextToken()); // n
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());
        int round = 1;

        while (true) {
            if (kim - lim == 1 && kim % 2 == 0) break;

            if (lim - kim == 1 && lim % 2 == 0) break;

            kim++;
            kim /= 2;
            lim++;
            lim /= 2;
            round++;
        }

        System.out.println(round);

        br.close();
    }
}