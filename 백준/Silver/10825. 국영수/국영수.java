import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Student {
		String name;
		int kor;
		int eng;
		int mat;
		
		public Student(String name, int kor, int eng, int mat) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Student> list = new ArrayList<>();
		
		for (int run = 0; run < n; run++) {
			st = new StringTokenizer(br.readLine());
			
			list.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1.kor != o2.kor) {
					return o2.kor - o1.kor;
					
				} else if (o1.eng != o2.eng) {
					return o1.eng - o2.eng;
					
				} else if (o1.mat != o2.mat) {
					return o2.mat - o1.mat;
					
				} else {
					return o1.name.compareTo(o2.name);
				}
			}
		});
		
		for (int i = 0; i < n; i++) {
			bw.write(list.get(i).name + "\n");
		}
		
		br.close();
		bw.close();
	}
}
