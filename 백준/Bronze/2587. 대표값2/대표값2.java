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
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		
		for (int run = 0; run < 5; run++) {
			list.add(Integer.parseInt(br.readLine()));
			sum += list.get(run);
		}
		
		list.sort(null);
		
		bw.write((sum / list.size()) + "\n" + list.get(2));
		bw.flush();

		br.close();
		bw.close();
	}
}
