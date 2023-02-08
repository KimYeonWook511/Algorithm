import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m;
	static boolean chk[];
	static int depthNode[];
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		chk = new boolean[n + 1];
		depthNode = new int[m];
		
		dfs(0);
		bw.flush();

		br.close();
		bw.close();
	}
	
	static void dfs(int depth) throws IOException {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				bw.write(depthNode[i] + " ");
			}
			
			bw.newLine();
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (!chk[i]) {
				depthNode[depth] = i;
				chk[i] = true;
				dfs(depth + 1);
				
				chk[i] = false;
			}
		}
	}
}