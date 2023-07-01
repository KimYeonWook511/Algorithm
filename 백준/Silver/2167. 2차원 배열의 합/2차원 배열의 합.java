import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());         
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
 
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 0; c < m; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
 
        int k = Integer.parseInt(br.readLine());

        for (int run = 0; run < k; run++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int sum = 0;

            for (int r = i; r <= x; r++) {
                for (int c = j; c <= y; c++) {
                    sum += arr[r][c];
                }
            }
            bw.write(sum + "\n");
        }
        
        br.close();
		bw.close();
    }
}