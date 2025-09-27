import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int man[] = new int[N];
        int woman[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            man[i] = Integer.parseInt(st.nextToken());
            woman[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(man);
        Arrays.sort(woman);

        int cnt = 0;
        int manIdx = 0;
        int womanIdx = N - 1;
        while (manIdx < N && womanIdx >= 0) {
            if (man[manIdx] < 0 && woman[womanIdx] < 0) {
                manIdx++;
                continue;
            }

            if (woman[womanIdx] < -man[manIdx]) {
                manIdx++;
                cnt++;
            }
            womanIdx--;
        }

        System.out.println(cnt);

        br.close();
    }
}