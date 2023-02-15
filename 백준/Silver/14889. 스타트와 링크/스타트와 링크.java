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
	static int n;
	static int startLink[][];
	static boolean team[]; // true -> start팀 / false -> link팀
	static int cnt; // 현재 조합 수
	static int min = 1000; // 능력치 차이의 최솟값
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		startLink = new int[n][n];
		team = new boolean[n];
		
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < n; c++) {
				startLink[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		bw.write(Integer.toString(min));
		bw.flush();

		br.close();
		bw.close();
	}
	
	static void dfs(int depth, int startIdx) {
		if (depth == n / 2) {
			for (int i = 0; i < n; i++) {
				splitTeam();
			}
            
			return;
		}
		
		for (int i = startIdx; i < n; i++) {
			team[i] = true;
			dfs(depth + 1, i + 1);
			team[i] = false;
		}
	}
	
	static void splitTeam() {
		int startTeam[] = new int[n / 2];
		int linkTeam[] = new int[n / 2];
		int startTeamIdx = 0;
		int linkTeamIdx = 0;
		
		for (int i = 0; i < n; i++) {
			if (team[i]) {
				startTeam[startTeamIdx] = i;
				startTeamIdx++;
				
			} else {
				linkTeam[linkTeamIdx] = i;
				linkTeamIdx++;
				
			}
		}
		
		cal(startTeam, linkTeam);
	}
	
	static void cal(int[] startTeam, int[] linkTeam) {
		int startSum = 0;
		int linkSum = 0;
		
		for (int i = 0; i < n / 2 - 1; i++) {
			for (int k = i + 1; k < n / 2; k++) {
				startSum += startLink[startTeam[i]][startTeam[k]];
				startSum += startLink[startTeam[k]][startTeam[i]];
				linkSum += startLink[linkTeam[i]][linkTeam[k]];
				linkSum += startLink[linkTeam[k]][linkTeam[i]];
			}
		}
		
		int result = Math.abs(startSum - linkSum);
		
		if (min > result) min = result;
	}
}