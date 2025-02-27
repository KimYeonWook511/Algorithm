import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int o1[], int o2[]) {
                return -Integer.compare(o1[1], o2[1]);
            }
        });

        int result = arr[0][1];
        for (int i = 0; i < n; i++) {
            if (arr[i][1] <= result) result = arr[i][1];

            result -= arr[i][0];
        }

        System.out.println(result);

        br.close();
    }
}