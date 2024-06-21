import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[2_000_001];

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine()) + 1_000_000]++;
        }
       
        for (int i = 0; i <= 2_000_000; i++) {
            if (arr[i] == 0) continue;

            for (int k = arr[i]; k > 0; k--) {
                sb.append(i - 1_000_000).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}