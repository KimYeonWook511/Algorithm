import java.util.*;

class Solution {
    public String solution(int[] numbers) { 
        Integer arr[] = new Integer[numbers.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numbers[i];
        }
        
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int v1 = o1 * getPow(o2) + o2;
                int v2 = o2 * getPow(o1) + o1;
                return -Integer.compare(v1, v2);
            }
        });
        
        if (arr[0] == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
    
    static int getPow(int val) {
        if (val >= 1000) return 10000;
        else if (val >= 100) return 1000;
        else if (val >= 10) return 100;
        else return 10;
    }
}