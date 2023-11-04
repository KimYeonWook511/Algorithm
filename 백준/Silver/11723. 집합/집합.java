import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        boolean arr[] = new boolean[20];

        String cmd = "";
        int num = 0;

        for (int run = 0; run < n; run++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();

            if (st.hasMoreTokens()) num = Integer.parseInt(st.nextToken()) - 1;

            if (cmd.equals("add")) arr[num] = true;
            else if (cmd.equals("remove")) arr[num] = false;
            else if (cmd.equals("check")) sb.append(arr[num] ? "1\n" : "0\n");
            else if (cmd.equals("toggle")) arr[num] = !arr[num];
            else {
                boolean flag = true;

                if (cmd.equals("empty")) flag = false;

                for (int i = 0; i < 20; i++) {
                    arr[i] = flag;
                }
            }
        }

        System.out.println(sb.toString());

        br.close();
    }
}