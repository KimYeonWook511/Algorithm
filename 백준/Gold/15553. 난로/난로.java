import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer arr[] = new Integer[N];
        int temp = 0;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = val - temp;
            temp = val;
        }

        arr[0] = Integer.MAX_VALUE;
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        int result = K;
        for (int i = 0; i < N - K; i++) {
            result += arr[i];
        }

        System.out.println(result);

        br.close();
    }
}