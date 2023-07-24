import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, String[]> map = new HashMap<>();
		
		for (int run = 0; run < n; run++) {
			String team = br.readLine();
			int cnt = Integer.parseInt(br.readLine());
			String member[] = new String[cnt];
			
			for (int i = 0; i < cnt; i++) {
				member[i] = br.readLine();
			}
			
			map.put(team, member);
		}
		
		for (int run = 0; run < m; run++) {
			String str = br.readLine();
			boolean quiz = br.readLine().equals("0") ? true : false;
			
			if (quiz) {
				String member[] = map.get(str);
				Arrays.sort(member);
				
				for (int i = 0; i < member.length; i++) {
					bw.write(member[i] + "\n");
				}
				
			} else {
				Iterator<String> key = map.keySet().iterator();
				boolean flag = true;
				
				while (flag) {
					String team = key.next();
					String member[] = map.get(team);
					
					for (int i = 0; i < member.length; i++) {
						if (member[i].equals(str)) {
							bw.write(team + "\n");
							flag = false;
							break;
						}
					}
				}
			}
		}

		br.close();
		bw.close();
	}
}