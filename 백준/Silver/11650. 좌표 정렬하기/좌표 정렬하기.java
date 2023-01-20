import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int xy[][] = new int[n][2]; // x, y 좌표
		StringTokenizer st;
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			xy[run][0] = x;
			xy[run][1] = y;
		}
		
		Arrays.sort(xy, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1]; // y좌표 비교
					
				} else {
					return o1[0] - o2[0]; // x좌표 비교
				}
			}
		});
		
		for (int i = 0; i < xy.length; i++) {
			bw.write(xy[i][0] + " " + xy[i][1] + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}