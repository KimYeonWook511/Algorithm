import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int arr[][] = new int[n + 1][n + 1];
      
      for (int r = 1; r <= n; r++) {
    	  st = new StringTokenizer(br.readLine());
    	  int sum = 0; // 같은 행의 합
    	  
    	  for (int c = 1; c <= n; c++) {
    		  sum += Integer.parseInt(st.nextToken());
    		  arr[r][c] = sum + arr[r - 1][c]; // 같은 행의 합 + 같은 열의 합 -> 직사각형의 합 
    	  }
      }
      
      for (int run = 0; run < m; run++) {
    	  st = new StringTokenizer(br.readLine());
    	  int x1 = Integer.parseInt(st.nextToken());
    	  int y1 = Integer.parseInt(st.nextToken());
    	  int x2 = Integer.parseInt(st.nextToken());
    	  int y2 = Integer.parseInt(st.nextToken());
    	  
    	  // x2, y2까지의 직사각형 - (x1 - 1, y2까지의 직사각형 + x2, y1 - 1까지의 직사각형) + x1 - 1, y1 - 1까지의 직사각형(빼는 직사각형끼리 겹치는 직사각형)
    	  bw.write(arr[x2][y2] - (arr[x1 - 1][y2] + arr[x2][y1 - 1]) + arr[x1 - 1][y1 - 1] + "\n");
      }
      
      bw.flush();

      br.close();
      bw.close();
   }
}