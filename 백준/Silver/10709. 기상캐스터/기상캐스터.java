import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int arr[][] = new int[H][W];
        
        for (int r = 0; r < H; r++) {
            String line = br.readLine();
            
            for (int c = 0; c < W; c++) {
                if (line.charAt(c) != 'c') arr[r][c] = -1;
            }
        }

        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (arr[r][c] != 0) continue;
                
                for (int i = c + 1; i < W; i++) {
                    if (arr[r][i] == 0) continue;
                    
                    arr[r][i] = arr[r][i - 1] + 1;
                }
            }
        }

        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                sb.append(arr[r][c]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        
        br.close();
    }
}