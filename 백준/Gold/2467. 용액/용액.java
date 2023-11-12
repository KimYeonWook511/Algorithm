import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int max = arr.length - 1;

        int valMin = arr[0];
        int valMax = arr[max];
        int val = Math.abs(arr[0] + arr[max]);

        while (min < max) {
            int v = arr[min] + arr[max];
            int absV = Math.abs(v);

            if (absV < val) {
                val = absV;
                valMin = arr[min];
                valMax = arr[max];
            }

            if (v < 0) min++;
            else if (v > 0) max--;
            else break;
        }

        sb.append(valMin).append(" ").append(valMax);
        System.out.println(sb.toString());

        br.close();
    }
}