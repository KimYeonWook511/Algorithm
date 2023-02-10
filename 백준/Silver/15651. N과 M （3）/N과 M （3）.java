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
	static int depthNode[];
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
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
			depthNode[depth] = i;
			dfs(depth + 1);
		}
	}
}