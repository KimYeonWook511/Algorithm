import java.io.*;
import java.util.*;

public class Main {
    static final int BASE = 36;
    static final int MAX_LENGTH = 100;

    static class Node {
        int arr[] = new int[MAX_LENGTH]; // i의 36진수 표현
        boolean isUsed = false;

        void add(int val, int startIdx) {
            arr[startIdx] += val;

            int cur = startIdx;
            while (arr[cur] >= BASE) {
                arr[cur + 1] += arr[cur] / BASE;
                arr[cur] %= BASE;
                cur++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node basic = new Node(); // 기존 val의 합
        Node plus[] = new Node[BASE]; // val -> 'Z'로 변환 시 얻는 값
        for (int i = 0; i < BASE; i++) {
            plus[i] = new Node();
        }
        
        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            String num = br.readLine();

            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(num.length() - 1 - i);

                int val = getVal(ch);
                basic.add(val, i);

                int plusVal = BASE - 1 - val;
                plus[plusVal].add(plusVal, i);
                plus[plusVal].isUsed = true;
            }
        }

        Arrays.sort(plus, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.isUsed != o2.isUsed) return o1.isUsed ? -1 : 1; // true를 앞으로

                if (o1.isUsed && o2.isUsed) {
                    for (int i = o1.arr.length - 1; i >= 0; i--) {
                        if (o1.arr[i] != o2.arr[i]) return -Integer.compare(o1.arr[i], o2.arr[i]); // 내림차순
                    }
                }

                return 0; // 혹시 모를 타이브레이커 (안정 정렬을 위해서 썼음, index작은 것을 앞으로 하며 '0', '1', ... , 'Y', 'Z' 순으로 바꾸도록)
            }
        });

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < BASE; i++) {
            if (!plus[i].isUsed) break;

            if (K == 0) break;
            K--;

            Node plusNode = plus[i];
            int plusNodeArr[] = plusNode.arr;
            for (int k = 0; k < plusNodeArr.length; k++) {
                basic.add(plusNodeArr[k], k);
            }
        }

        System.out.println(getBaseString(basic));

        br.close();
    }

    static int getVal(char ch) {
        if (ch >= '0' && ch <= '9') return ch - '0';
        else return ch - 'A' + 10;
    }

    static String getBaseString(Node node) {
        int arr[] = node.arr;

        int top = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                top = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = top; i >= 0; i--) {
            sb.append(arr[i] < 10 ? (char)(arr[i] + '0') : (char)(arr[i] - 10 + 'A'));
        }

        return sb.toString();
    }
}