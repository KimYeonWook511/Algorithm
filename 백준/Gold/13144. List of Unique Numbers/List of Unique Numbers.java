import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean chk[] = new boolean[100_001];
        int len = 0;
        long result = 0;

        int leftIdx = 0;
        for (int i = 0; i < N; i++) {
            if (chk[arr[i]]) {
                while (leftIdx < i) {
                    chk[arr[leftIdx]] = false;
                    leftIdx++;
                    len--;
                    
                    if (arr[leftIdx - 1] == arr[i]) break;
                }
            }

            chk[arr[i]] = true;
            len++;
            result += len;
        }

        System.out.println(result);

        br.close();
    }
}