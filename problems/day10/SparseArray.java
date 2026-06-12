import java.util.*;

public class SparseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String query = sc.next();
            System.out.println(freq.getOrDefault(query, 0));
        }
    }
}
