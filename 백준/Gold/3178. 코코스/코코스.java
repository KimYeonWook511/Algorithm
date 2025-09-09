import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        Map<Character, Node> child = new HashMap<>();
    }

    static class Trie {
        Node head = new Node(); // forward
        Node tail = new Node(); // reverse

        int insert(String word, int K) {
            Node forward = this.head;
            Node reverse = this.tail;
            int newNodeCount = 0;

            for (int i = 0; i < K; i++) {
                char forwardCharacter = word.charAt(i);
                char reverseCharacter = word.charAt(word.length() - 1 - i);

                if (forward.child.get(forwardCharacter) == null) {
                    forward.child.put(forwardCharacter, new Node());
                    newNodeCount++;
                }
                if (reverse.child.get(reverseCharacter) == null) {
                    reverse.child.put(reverseCharacter, new Node());
                    newNodeCount++;
                }

                forward = forward.child.get(forwardCharacter);
                reverse = reverse.child.get(reverseCharacter);
            }

            return newNodeCount;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();

        int result = 0;
        for (int n = 0; n < N; n++) {
            String word = br.readLine();

            result += trie.insert(word, K);
        }

        System.out.println(result);

        br.close();
    }
}