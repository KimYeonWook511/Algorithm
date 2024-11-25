import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result[] = new int[N + 1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i % 2 == 0 ? -arr[i] : arr[i];
        }

        result[1] = sum >> 1;
        for (int i = 2; i <= N; i++) {
            result[i] = arr[i - 1] - result[i - 1];
        }

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}