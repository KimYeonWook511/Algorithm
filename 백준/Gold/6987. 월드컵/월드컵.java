import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int p[][], cnt[]; 
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		for (int run = 0; run < 4; run++) {
			p = new int[6][3];
			cnt = new int[3];
			flag = true;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				cnt[0] += p[i][0] = Integer.parseInt(st.nextToken());
				cnt[1] += p[i][1] = Integer.parseInt(st.nextToken());
				cnt[2] += p[i][2] = Integer.parseInt(st.nextToken());
				
				if (p[i][0] + p[i][1] + p[i][2] != 5) flag = false;
			}
			
			if (!flag || cnt[0] != cnt[2] || cnt[1] % 2 != 0) { // 5경기를 하지 않았음 || 승패가 안 맞음 || 무승부가 안 맞음
				sb.append("0 ");
				continue;
			}
			
			sb.append(func(0, 1, 0) ? "1 " : "0 ");
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static boolean func(int i, int k, int cnt) {
		if (cnt == 15) return true;
		
		if (i == 5) return false;
		if (k == 6) return func(i + 1, i + 2, cnt);
		
		boolean flag = false;
		
		// 승, 패
		if (p[i][0] > 0 && p[k][2] > 0) {
			p[i][0]--;
			p[k][2]--;
			flag |= func(i, k + 1, cnt + 1);
			p[i][0]++;
			p[k][2]++;
		}
		
		// 무승부
		if (p[i][1] > 0 && p[k][1] > 0) {
			p[i][1]--;
			p[k][1]--;
			flag |= func(i, k + 1, cnt + 1);
			p[i][1]++;
			p[k][1]++;
		}
		
		// 패, 승
		if (p[i][2] > 0 && p[k][0] > 0) {
			p[i][2]--;
			p[k][0]--;
			flag |= func(i, k + 1, cnt + 1);
			p[i][2]++;
			p[k][0]++;
		}
		
		return flag;
	}
}