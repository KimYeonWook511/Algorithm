import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // double a = Double.parseDouble(st.nextToken());
        BigDecimal a = new BigDecimal(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // input : 3.141592 3
        // System.out.println(Math.pow(a, b)); // 31.006257328285752
        // System.out.println(a.pow(b));          // 31.006257328285746688
        System.out.println(a.pow(b).stripTrailingZeros().toPlainString());

        br.close();
    }
}
