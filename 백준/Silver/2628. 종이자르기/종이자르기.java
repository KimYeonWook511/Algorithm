import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		
		TreeSet<Integer> wSet = new TreeSet<Integer>(); // 세로로 자르는 경우
		TreeSet<Integer> hSet = new TreeSet<Integer>(); // 가로로 자르는 경우
		
		wSet.add(0);
		wSet.add(w);
		hSet.add(0);
		hSet.add(h);
		
		w = 0;
		h = 0;
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			
			if (st.nextToken().equals("0")) hSet.add(Integer.parseInt(st.nextToken()));
			else wSet.add(Integer.parseInt(st.nextToken()));
		}
		
		Integer wArr[] = wSet.toArray(new Integer[0]);
		Integer hArr[] = hSet.toArray(new Integer[0]);
		
		for (int i = 1; i < hArr.length; i++) {
			w = Math.max(w, hArr[i] - hArr[i - 1]);
		}
		
		for (int i = 1; i < wArr.length; i++) {
			h = Math.max(h, wArr[i] - wArr[i - 1]);
		}
		
		System.out.println(w * h);
		
		br.close();
	}
}
