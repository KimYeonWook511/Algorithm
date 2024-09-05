import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int bCnt = 0;
        int rCnt = 0;
        int leftToRightBCnt = 0;
        int rightToLeftBCnt = 0;
        int leftToRightRCnt = 0;
        int rightToLeftRCnt = 0;
        boolean leftToRightBFlag = false;
        boolean rightToLeftBFlag = false;
        boolean leftToRightRFlag = false;
        boolean rightToLeftRFlag = false;

        for (int i = 0; i < N; i++) {
            char leftC = input.charAt(i);
            char rightC = input.charAt(N - i - 1);

            if (leftC == 'R') {
                rCnt++;

                leftToRightBFlag = true;
                if (!leftToRightRFlag) leftToRightRCnt++;

            } else if (leftC == 'B') {
                bCnt++;

                leftToRightRFlag = true;
                if (!leftToRightBFlag) leftToRightBCnt++;
            }

            if (rightC == 'R') {
                rightToLeftBFlag = true;
                if (!rightToLeftRFlag) rightToLeftRCnt++;

            } else if (rightC == 'B') {
                rightToLeftRFlag = true;
                if (!rightToLeftBFlag) rightToLeftBCnt++;
            }
        }

        System.out.println(Math.min(bCnt - Math.max(leftToRightBCnt, rightToLeftBCnt), rCnt - Math.max(leftToRightRCnt, rightToLeftRCnt)));

        br.close();
    }
}