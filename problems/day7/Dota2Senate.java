package problems.day7;

import java.util.*;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        // Fill queues with indices of senators
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') radiant.add(i);
            else dire.add(i);
        }

        // Simulate banning process
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();

            if (r < d) {
                // Radiant senator bans Dire senator, re-add Radiant with new index
                radiant.add(r + n);
            } else {
                // Dire senator bans Radiant senator, re-add Dire with new index
                dire.add(d + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Dota2Senate solver = new Dota2Senate();
        System.out.println(solver.predictPartyVictory("RD"));     // Radiant
        System.out.println(solver.predictPartyVictory("RDD"));    // Dire
    }
}
