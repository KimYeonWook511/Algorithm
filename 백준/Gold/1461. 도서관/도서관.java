import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int neg = 0;
        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] < 0) neg++;
        }

        Arrays.sort(arr);
        
        int sum = 0;
        int left = 0;
        int right = N - 1;

        if (Math.abs(arr[0]) < Math.abs(arr[N - 1])) {
            sum = Math.abs(arr[N - 1]);
            right -= M;

        } else {
            sum = Math.abs(arr[0]);
            left += M;
        }

        for (int i = left; i < neg; i += M) {
            sum += Math.abs(arr[i]) * 2;
        }

        for (int i = right; i >= neg; i -= M) {
            sum += Math.abs(arr[i]) * 2;
        }

        System.out.println(N == 1 ? Math.abs(arr[0]) : sum);

        br.close();
    }
}