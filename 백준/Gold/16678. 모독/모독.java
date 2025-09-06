import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long result = 0;
        int temp = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] < temp) continue;

            result += (arr[i] - temp);
            temp++;
        }

        System.out.println(result);

        br.close();
    }
}