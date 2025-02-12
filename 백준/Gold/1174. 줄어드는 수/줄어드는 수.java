import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int bitMax = 1 << 10;
        long arr[] = new long[bitMax];
        int idx = 0;

        if (N < bitMax) {
            for (int i = 1; i < bitMax; i++) {
                long num = 0;
    
                for (int k = 0; k < 10; k++) {
                    if ((i & (1 << k)) == 0) continue;
    
                    num = num * 10 + 9 - k;
                }
    
                arr[idx++] = num;
            }

            Arrays.sort(arr);
        }

        System.out.println(N < bitMax ? arr[bitMax - idx + N - 1] : -1);

        br.close();
    }
}