import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long arr[][] = new long[N + 1][2];
        long sum[] = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        arr[0][0] = Integer.MIN_VALUE; // 정렬 안 되게 -> 최소는 -1_000_000_000 이므로 -1더 해서 넣어도 됨

        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0], o2[0]);
            }
        });

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i][1];
        }
        
        int left = 1;
        int right = N;
        
        while (left <= right) {
        	int mid = (left + right) >> 1;
        
	        if (sum[mid] < sum[N] - sum[mid]) left = mid + 1;
	        else right = mid - 1;
        }
        
        System.out.println(arr[left][0]);
        
        /* 가능한 경우가 여러 가지인 경우에 더 큰 위치를 출력하는 경우
        while (left <= right) {
        	int mid = (left + right) >> 1;
        
	        if (sum[mid - 1] <= sum[N] - sum[mid - 1]) left = mid + 1;
	        else right = mid - 1;
        }

        System.out.println(arr[right][0]);
        */
        
        br.close();
    }
}