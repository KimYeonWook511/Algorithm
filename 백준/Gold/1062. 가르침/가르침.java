import java.io.*;
import java.util.*;

public class Main {
	static int N, K, sumBit, arr[], max;
	static int anticBit;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	K = Integer.parseInt(st.nextToken());
    	
    	sumBit = 0;
    	arr = new int[N];
    	
    	for (int i = 0; i < N; i++) {
    		String str = br.readLine();
    		int len = str.length();
    		int bit = 0;
    		
    		int m = 0;
    		for (int k = 0; k < len; k++) {
    			m = str.charAt(k) - 'a';
    			
    			sumBit |= 1 << m;
    			bit |= 1 << m;
    		}
    		
    		arr[i] = bit;
    	}
    	
    	int cnt = 0;
    	for (int i = 0; i < 26; i++) {
    		if ((sumBit & (1 << i)) != 0) cnt++;
    	}
    	
    	if (K >= cnt) max = N;
    	else if (K >= 5) {
    		anticBit |= 1 << ('a' - 'a');
    		anticBit |= 1 << ('n' - 'a');
    		anticBit |= 1 << ('t' - 'a');
    		anticBit |= 1 << ('i' - 'a');
    		anticBit |= 1 << ('c' - 'a');
    		sumBit ^= anticBit;
    		
    		func(0, anticBit, 5);
    	}
    	
    	System.out.println(max);
    	
        br.close();
    }
    
    static void func(int startIdx, int checkBit, int cnt) {
    	if (cnt == K) {
    		int count = 0;
    		
    		// 몇개 있는지 계산 로직
    		for (int i = 0; i < N; i++) {
    			if (arr[i] == (arr[i] & checkBit)) count++;
    		}
    		
    		max = Math.max(max, count);
    		
    		return;
    	}
    	
    	for (int i = startIdx; i < 26; i++) {
    		if ((sumBit & (1 << i)) == 0) continue;
    		
    		func(i + 1, checkBit | (1 << i), cnt + 1);
    	}
    }
}