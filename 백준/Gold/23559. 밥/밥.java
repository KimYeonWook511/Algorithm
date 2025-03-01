import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -Integer.compare(o1[0] - o1[1], o2[0] - o2[1]);
            }
        });

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (X - 5000 >= (N - i - 1) * 1000 && arr[i][0] > arr[i][1]) {
                result += arr[i][0];
                X -= 5000;
            } else {
                result += arr[i][1];
                X -= 1000;
            }
        }
		
		System.out.println(result);

        br.close();
    }
}