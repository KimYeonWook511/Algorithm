import java.io.*;
import java.util.*;

public class Main {
    static int N, K, arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
 
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
 
        double result = Double.MAX_VALUE;
        for (int i = K; i <= N; i++) {
            for (int j = 0; j <= N - i; j++) {
                double avg = calAvg(i, j);

                result = Math.min(result, calStandardDeviation(i, j, avg));
            }
        }
 
        System.out.println(String.format("%.11f", result));

        br.close();
    }

    static double calAvg(int i, int j) {
        double sum = 0.0;

        for (int idx = 0; idx < i; idx++) {
            sum += arr[j + idx];
        }

        return sum / i;
    }
    
    static double calStandardDeviation(int i, int j, double avg) {
        double sum = 0.0;

        for (int idx = 0; idx < i; idx++) {
            sum += Math.pow(arr[j + idx] - avg, 2);
        }

        return Math.sqrt(sum / i);
    }
}