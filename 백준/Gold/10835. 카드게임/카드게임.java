import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int a[];
	static int b[];
	static int dp[][];
	
	public static void main(String[] args) throws IOException {
		
		n=Integer.parseInt(br.readLine());
		a=new int[n];
		b=new int[n];
		dp=new int[n][n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for (int i=0; i<n; i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		
		st=new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			b[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<n; i++)
			Arrays.fill(dp[i],-1);
		
		System.out.println(v(0,0));
		br.close();
	}
	
	public static int v(int left, int right) {
		if (left==n || right==n) {
			return 0;
		}
		
		if (dp[left][right]!=-1) {
			return dp[left][right];
		}
		
		dp[left][right]=Math.max(v(left+1,right), v(left+1,right+1));
		
		if (a[left]>b[right]) dp[left][right]=v(left,right+1) + b[right];
		
		return dp[left][right];
	}
}