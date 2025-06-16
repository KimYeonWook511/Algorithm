import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int alphabet[] = new int[26];
        
        int cnt = 0;
        int start = 0;
        int result = 0;
        for(int end = 0; end < str.length(); end++) {
            if(++alphabet[str.charAt(end) - 'a'] == 1) cnt++;
            
            while (N < cnt) {
                if (--alphabet[str.charAt(start) - 'a'] == 0) cnt--;
                
                start++;
            }
            
            result = Math.max(result, end - start + 1);
        }
        
        System.out.println(result);
		
		br.close();
	}
}