import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static class Serial {
		String number;
		int sum;
		
		Serial(String number) {
			this.number = number;
			
			for (int i = 0; i < number.length(); i++) {
				int c = number.charAt(i) - '0';
				
				if (c >= 0 && c <= 9) this.sum += c;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Serial> list = new ArrayList<>();
		
		for (int run = 0; run < n; run++) {
			list.add(new Serial(br.readLine()));
		}
		
		Collections.sort(list, new Comparator<Serial>() {
			@Override
			public int compare(Serial o1, Serial o2) {
				if (o1.number.length() != o2.number.length()) return o1.number.length() - o2.number.length();
				else if (o1.sum != o2.sum) return o1.sum - o2.sum;
				else return o1.number.compareTo(o2.number);
			}
		});
		
		for (int i = 0; i < n; i++) {
			bw.write(list.get(i).number + "\n");
		}
		
		br.close();
		bw.close();
	}
}
