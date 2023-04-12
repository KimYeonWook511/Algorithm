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
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[26]; // A C G T
		
		arr['A' - 'A'] = Integer.parseInt(st.nextToken());
		arr['C' - 'A'] = Integer.parseInt(st.nextToken());
		arr['G' - 'A'] = Integer.parseInt(st.nextToken());
		arr['T' - 'A'] = Integer.parseInt(st.nextToken());
		
		int startIdx = 0;
		int endIdx = p - 1;
		int cnt = 0;
		
		for (int i = startIdx; i <= endIdx; i++) {
			arr[str.charAt(i) - 'A']--;
		}
		
		if (arr['A' - 'A'] <= 0 && arr['C' - 'A'] <= 0 && arr['G' - 'A'] <= 0 && arr['T' - 'A'] <= 0) cnt++;
		
		startIdx++;
		endIdx++;
		
		while (endIdx < s) {
			arr[str.charAt(startIdx - 1) - 'A']++;
			arr[str.charAt(endIdx) - 'A']--;
			
			if (arr['A' - 'A'] <= 0 && arr['C' - 'A'] <= 0 && arr['G' - 'A'] <= 0 && arr['T' - 'A'] <= 0) cnt++;
			
			startIdx++;
			endIdx++;
		}
		
		bw.write(Integer.toString(cnt));
		bw.flush();

		br.close();
		bw.close();
	}
}