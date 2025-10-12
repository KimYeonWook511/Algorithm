import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		boolean arr[] = new boolean[N]; // true: W | false: B

		String input = br.readLine();
		for (int i = 0; i < N; i++) {
			arr[i] = input.charAt(i) == 'W';
		}

		int answer = 0;
		int countB = 0;
		int countW = 0;
		int left = 0;
		int right = 0;
		while (right < N) {
			if (arr[right]) countW++;
			else countB++;
			right++;

			while (right < N && countW < W) {
				if (arr[right]) countW++;
				else countB++;
				right++;
			}

			while (left < right && countB > B) {
				if (arr[left]) countW--;
				else countB--;
				left++;
			}

			if (countB <= B && countW >= W) {
				answer = Math.max(answer, countB + countW);
			}
		}

		System.out.println(answer);

        br.close();
    }
}