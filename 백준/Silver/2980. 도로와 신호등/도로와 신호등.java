import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
 
        int time = 0;
        int temp = 0;
 
        int D, R, G;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
 
            time += D - temp;
            temp = D;
 
            int val = time % (R + G);
            if (val < R) time += R - val;           
        }
 
        time += L - temp;
 
        System.out.println(time);
        
        br.close();
    }
}