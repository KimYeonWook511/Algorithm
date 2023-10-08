import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long sum = 0;
        int idx = 0;

        for (int i = 0; i < a; i++) {
            sum += arr[i] / 2;

            if (sum > b) {
                n = 0;
                break;
            }

            idx = i + 1;
        }

        for (int i = a; i < n; i++) {
            sum += (arr[i - a] / 2) + (arr[i] / 2);

            if (sum > b) {
                n = 0;
                break;
            }

            idx = i + 1;
        }

        System.out.println(idx);

        br.close();
    }
}