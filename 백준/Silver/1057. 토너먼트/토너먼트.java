import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer.parseInt(st.nextToken()); // n
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());
        int round = 0;

        while (kim != lim) {
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