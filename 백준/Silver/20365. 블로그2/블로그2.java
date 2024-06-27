import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int rCnt = 0;
        int bCnt = 0;
        char temp = 0;
        char cur = 0;

        for (int i = 0; i < N; i++) {
            cur = str.charAt(i);

            if (cur == temp) continue;

            if (cur == 'R') rCnt++;
            else bCnt++;

            temp = cur;
        }

        System.out.println(Math.min(rCnt, bCnt) + 1);

        br.close();
    }
}