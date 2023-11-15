import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long target = Y * 100 / X + 1;

        long left = 0;
        long right = X;

        if (target >= 100) {
            right = -1;

        } else {
            while (left < right) {
                long mid = (left + right) / 2;
    
                long tempX = X + mid;
                long tempY = Y + mid;
                
                long per = tempY * 100 / tempX;
    
                if (per >= target) right = mid;
                else left = mid + 1;
            }
        }

        System.out.println(right);

        br.close();
    }
}