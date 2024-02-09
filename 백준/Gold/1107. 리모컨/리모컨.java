import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        String N = br.readLine();
        int target = Integer.parseInt(N);

        boolean btn[] = new boolean[10];
        int M = Integer.parseInt(br.readLine());
        
        if (M != 0) {
            st = new StringTokenizer(br.readLine());

            for (int run = 0; run < M; run++) {
                btn[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int min = Math.abs(target - 100);

        int k = 0;
        String num = "";
        boolean flag = true;
        int len = 0;

        while (true) {
            if (target + k >= 1000000) break;

            num = Integer.toString(target + k);
            len = num.length();
            flag = true;

            for (int i = 0; i < len; i++) {
                if (btn[num.charAt(i) - '0']) flag = false;
            }

            if (flag) {
                min = Math.min(min, len + k);
                break;
            }

            k++;
        }

        k = 0;

        while (true) {
            if (target - k < 0) break;

            num = Integer.toString(target - k);
            len = num.length();
            flag = true;

            for (int i = 0; i < len; i++) {
                if (btn[num.charAt(i) - '0']) flag = false;
            }

            if (flag) {
                min = Math.min(min, len + k);
                break;
            }

            k++;
        }

        System.out.println(min);

        br.close();
    }
}