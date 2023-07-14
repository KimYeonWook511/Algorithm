import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		st = new StringTokenizer(br.readLine());
		int nA = Integer.parseInt(st.nextToken());
		int nB = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int run = 0; run < nA; run++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for (int run = 0; run < nB; run++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (set.contains(num)) set.remove(num);
		}
		
		bw.write(set.size() + "\n");
		
		while (!set.isEmpty()) {
			bw.write(set.pollFirst() + " ");
		}
		
		br.close();
		bw.close();
	}
}