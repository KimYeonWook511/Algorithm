import java.io.*;

public class Main {
	static String S;
	static boolean flag = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();
		
		func(br.readLine());
		
		System.out.println(flag ? "1" : "0");

		br.close();
	}
	
	static void func(String T) {
		if (S.length() == T.length()) {
    		if (S.equals(T)) flag = true;
    		
    		return;
    	}

		if (T.charAt(0) == 'B') func(new StringBuilder(T.substring(1)).reverse().toString());
		if (T.charAt(T.length() - 1) == 'A') func(T.substring(0, T.length() - 1));
	}
}