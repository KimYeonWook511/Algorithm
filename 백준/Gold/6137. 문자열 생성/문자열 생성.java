import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char S[] = new char[N];

        for (int i = 0; i < N; i++) {
            S[i] = br.readLine().charAt(0);
        }

        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            if (S[left] < S[right]) {
                sb.append(S[left++]);
            } else if (S[left] > S[right]) {
                sb.append(S[right--]);
            } else {
                int nextLeft = left;
                int nextRight = right;

                while (nextLeft < nextRight) {
                    if (S[nextLeft] != S[nextRight]) break;

                    nextLeft++;
                    nextRight--;
                }

                if (nextLeft < nextRight && S[nextLeft] > S[nextRight]) {
                    sb.append(S[right--]);
                } else {
                    sb.append(S[left++]);
                }
            }

            int cnt = left + (N - 1 - right);
            if (cnt % 80 == 0) sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}