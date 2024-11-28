import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        double result = 0.0;
        double p = func(N, M);

        while(M >= K){
            if(N - M < M - K){
                K++;
                continue;
            }

            double c = func(M, K) * func(N - M, M - K);

            result += c / p;
            K++;
        }

        System.out.println(result);

        br.close();
    }

    static long func(int n, int r){
        int p = 1;
        int c = 1;

        while(r > 0){
            c *= n;
            p *= r;

            n--;
            r--;
        }

        return c / p;
    }
}