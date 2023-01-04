import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine());	
		
		int[] a = new int[testcase];
		int[] b = new int[testcase];
		
		for (int i = 0; i < testcase; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			bw.write(a[i] + b[i] + "\n");
		}
		bw.flush();
		
		br.close();
		bw.close();
	}
}