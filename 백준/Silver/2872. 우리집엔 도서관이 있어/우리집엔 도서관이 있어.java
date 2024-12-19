import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

		int val = N;
		int cnt = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == val) val--;
            else cnt++;
        }
		
		System.out.println(cnt);

        br.close();
    }
}