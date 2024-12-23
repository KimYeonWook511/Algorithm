import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;
        int maxLen = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            result += Integer.bitCount(num);
            maxLen = Math.max(maxLen, Integer.toBinaryString(num).length() - 1);
        }

        System.out.println(result + maxLen);

        br.close();
    }
}