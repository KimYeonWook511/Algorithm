import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        int num = 0;
        for(int i = 1; i <= n; i++) {
            num = i;
            
            while (num > 0) {
            	if (num % 10 == d) cnt++;
            	
            	num /= 10;
            }
        }

        System.out.println(cnt);
        
        br.close();
    }
}