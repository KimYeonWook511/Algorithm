import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long R = Long.parseLong(st.nextToken());

        System.out.println(N + 1 + ((R - 1) << 1));

        br.close();
    }
}