import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int max = 0;
        int cnt = 1;
        int temp = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] == temp) {
                cnt++;
                continue;
            }

            max = Math.max(max, cnt);
            temp = arr[i];
            cnt = 1;
        }

        System.out.println(Math.max(max, cnt));

        br.close();
    }
}