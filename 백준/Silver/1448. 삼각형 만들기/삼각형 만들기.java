import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = 0;
		boolean flag = false;
		
		for (int run = 0; run < n; run++) {
			int num = Integer.parseInt(br.readLine());
			
			list.add(num);
		}
		
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		for (int i = 0; i < list.size() - 2; i++) {
			int a = list.get(i);
			int b = list.get(i + 1) + list.get(i + 2);
			
			if (a < b) {
				sum = a + b;
				flag = true;
				break;
			}
		}
		
		System.out.println(flag ? sum : "-1");
		
		br.close();
	}
}