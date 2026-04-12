import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long fact[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cmd = Integer.parseInt(st.nextToken());

        if (cmd == 1) {
            long k = Long.parseLong(st.nextToken());
            findPerm(k);
        } else {
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            findOrder(arr);
        }

        System.out.println(sb);

        br.close();
    }

    static void findPerm(long k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        k--;
        for (int i = N; i >= 1; i--) {
            long blockSize = fact[i - 1];
            int index = (int)(k / blockSize);

            sb.append(numbers.get(index)).append(" ");
            numbers.remove(index);

            k %= blockSize;
        }
    }

    static void findOrder(int arr[]) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        long order = 1;
        for (int i = 0; i < N; i++) {
            int index = numbers.indexOf(arr[i]);
            order += (long) index * fact[N - 1 - i];
            numbers.remove(index);
        }

        sb.append(order);
    }
}