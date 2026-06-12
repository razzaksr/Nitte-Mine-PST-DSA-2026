package problems.day4;

import java.util.*;

public class FairCandySwap {
    public int[] fairCandySwap(int[] alice, int[] bob) {
        int sumA = 0, sumB = 0;
        for (int a : alice) sumA += a;
        for (int b : bob) sumB += b;
        int diff = (sumA - sumB) / 2; // difference to balance
        Set<Integer> setA = new HashSet<>();
        for (int a : alice) setA.add(a);
        for (int b : bob)
            if (setA.contains(b + diff)) return new int[]{b + diff, b};
        return new int[]{};
    }

    public static void main(String[] args) {
        FairCandySwap fcs = new FairCandySwap();
        int[] alice = {1,1};
        int[] bob = {2,2};
        System.out.println(Arrays.toString(fcs.fairCandySwap(alice, bob))); // [1,2]
    }
}
