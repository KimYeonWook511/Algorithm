import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[2 * n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = 200000;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i] + arr[arr.length - i - 1]);
        }

        System.out.println(min);

        br.close();
    }
}