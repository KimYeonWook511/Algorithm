import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        System.out.println(func(B) - func(A - 1));

        br.close();
    }

    static long func(long X) {
        long cnt = 0;

        for (long i = 1; i <= X; i <<= 1) {
            long temp = i << 1;
            long quot = (X + 1) / temp;
            long rem = (X + 1) % temp;
            
            cnt += quot * i + Math.max(rem - i, 0);
        }

        return cnt;
    }
}