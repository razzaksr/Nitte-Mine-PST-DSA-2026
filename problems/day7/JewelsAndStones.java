package problems.day7;

import java.util.*;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }

        int count = 0;
        for (char s : stones.toCharArray()) {
            if (jewelSet.contains(s)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        JewelsAndStones solver = new JewelsAndStones();
        System.out.println(solver.numJewelsInStones("aA", "aAAbbbb")); // 3
        System.out.println(solver.numJewelsInStones("z", "ZZ"));       // 0
    }
}
