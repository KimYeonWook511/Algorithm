import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	int p[] = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int M = Integer.parseInt(br.readLine());
    	BigInteger dp[][] = new BigInteger[M + 1][N]; // 사용할 수 있는 값 / 시작 숫자
    	
    	for (int i = 0; i < N; i++) {
    		p[i] = Integer.parseInt(st.nextToken());
    		dp[0][i] = BigInteger.ZERO;
    	}
    	
    	// 방번호가 0인 경우도 고려할 것 (적어도 하나의 숫자를 살 수 있어서 이미 포함됨)
    	for (int r = 1; r <= M; r++) {
    		BigInteger tempMax = dp[r - 1][N - 1];
    		
    		for (int c = 1; c < N; c++) {
    			dp[r][c] = tempMax;
    			
    			if (r >= p[c]) {
    				dp[r][c] = dp[r][c].max(BigInteger.TEN.pow((r - p[c]) / p[0]).multiply(BigInteger.valueOf(c)));
    				
					if (dp[r - p[c]][N - 1] != BigInteger.ZERO) dp[r][c] = dp[r][c].max(BigInteger.TEN.pow(dp[r - p[c]][N - 1].toString().length()).multiply(BigInteger.valueOf(c)).add(dp[r - p[c]][N - 1]));
    			}
    			
    			tempMax = tempMax.max(dp[r][c]);
    		}
    	}
    	
    	System.out.println(dp[M][N - 1] == null ? "0" : dp[M][N - 1]);
    	
        br.close();
    }
}