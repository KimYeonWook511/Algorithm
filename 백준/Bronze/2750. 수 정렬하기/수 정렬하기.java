import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int run = 0; run < n; run++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		list.sort(null);
		
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + "\n");
		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}
