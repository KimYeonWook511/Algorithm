import java.io.*;
import java.util.*;

public class Main {
    static int k, arr[];
    static boolean sign[], chk[] = new boolean[10], flag;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        sign = new boolean[k]; 
        arr = new int[k + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            if (st.nextToken().equals("<")) sign[i] = true;
        }

        for (int i = 9; i >= 0; i--) {
            arr[0] = i;
            chk[i] = true;
            func(1);
            chk[i] = false;

            if (flag) break;
        }

        flag = false;

        for (int i = 0; i < 10; i++) {
            arr[0] = i;
            chk[i] = true;
            func(1);
            chk[i] = false;

            if (flag) break;
        }

        System.out.println(sb.toString());
        
        br.close();
    }

    static void func(int idx) {
        if (flag) return;

        if (idx > k) {
            flag = true;

            for (int i = 0; i <= k; i++) {
                sb.append(arr[i]);
            }
            sb.append("\n");

            return;
        }

        if (sign[idx - 1]){ 
            // <
            for (int i = arr[idx - 1] + 1; i < 10; i++) {
                if (!chk[i]) {
                    arr[idx] = i;
                    chk[i] = true;
                    func(idx + 1);
                    chk[i] = false;
                }
            }    

        } else {
            // >
            for (int i = arr[idx - 1] - 1; i >= 0; i--) {
                if (!chk[i]) {
                    arr[idx] = i;
                    chk[i] = true;
                    func(idx + 1);
                    chk[i] = false;
                }
            }
        }
    }
}