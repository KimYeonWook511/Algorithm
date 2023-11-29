import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[M][4];
        char DNA[] = {'A', 'C', 'G', 'T'};

        for (int run = 0; run < N; run++) {
            char str[] = br.readLine().toCharArray();

            for (int i = 0; i < M; i++) {
                switch (str[i]) {
                    case 'A':
                        arr[i][0]++;
                        break;
                    case 'C':
                        arr[i][1]++;
                        break;
                    case 'G':
                        arr[i][2]++;
                        break;
                    case 'T':
                        arr[i][3]++;
                        break;
                }
            }
        }

        int HD = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            char c = 'Z';
            int max = 0;

            for (int k = 0; k < 4; k++) {
                if (arr[i][k] > max) {
                    max = arr[i][k];
                    c = DNA[k];
                }
            }

            HD += N - max;
            sb.append(c);
        }

        sb.append("\n").append(HD);

        System.out.println(sb.toString());
    }
}