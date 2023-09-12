import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        double arr[] = {100.000, 100.000, 100.000, 100.000, 100.000, 100.000, 100.000};

        for (int run = 0; run < n; run++) {
            double f = Double.parseDouble(br.readLine());

            if (arr[6] > f) arr[6] = f;

            Arrays.sort(arr);
        }

        for (int i = 0; i < 7; i++) {
            sb.append(String.format("%.3f", arr[i])).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }
}
