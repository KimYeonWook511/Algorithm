import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        BigInteger T = BigInteger.valueOf((long)(10000 * Double.parseDouble(st.nextToken())));
        BigInteger x[] = new BigInteger[N]; // 미터 단위
        BigInteger v[] = new BigInteger[N]; // 초당 미터

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            x[i] = BigInteger.valueOf(10000 * Long.parseLong(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            v[i] = BigInteger.valueOf(Long.parseLong(st.nextToken())); // 어차피 long으로 캐스팅 됨
        }

        BigInteger bigMin = BigInteger.ONE;
        BigInteger bigMax = new BigInteger("1000000000");
        BigInteger left = bigMin.max(x[0].subtract(T.multiply(v[0])));
        BigInteger right = bigMax.min(x[0].add(T.multiply(v[0])));
        int answer = 1;
        for (int i = 1; i < N; i++) {
            BigInteger l = bigMin.max(x[i].subtract(T.multiply(v[i])));
            BigInteger r = bigMax.min(x[i].add(T.multiply(v[i])));

            left = left.max(l);
            right = right.min(r);
            if (left.compareTo(right) > 0) {
                // 실패
                answer = 0;
                break;
            }
        }

        System.out.println(answer);

        br.close();
    }
}