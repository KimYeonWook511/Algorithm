import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[367];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start]++;
            arr[end + 1]--;
        }

        int sum = 0;
        int width = 0;
        int height = 0;
        
        for (int i = 1; i <= 366; i++) {
            arr[i] += arr[i - 1];
            
            if (arr[i] == 0) {
            	sum += width * height;
            	width = 0;
            	height = 0;
            	
            } else {
            	width++;
            	height = Math.max(arr[i], height);
            }
        }
            
        System.out.println(sum);
		
		br.close();
	}
}