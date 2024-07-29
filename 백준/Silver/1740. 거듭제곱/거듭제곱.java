import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long N = Long.parseLong(br.readLine());

        Long result = 0L;
        
        while (N > 0L) {
            Long cnt = 0L;
            Long num = 1L;
            
            while (N >= num * 2L) {
                num *= 2L;
                cnt++;
            }
            
            N -= num;
            
            Long val = 1L;
            for (int i = 0; i < cnt; i++) {
            	val *= 3;
            }
            
            result += val;
        }
        
        System.out.println(result);
        
        br.close();
    }
}