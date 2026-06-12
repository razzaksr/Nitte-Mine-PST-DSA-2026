package problems.day7;

import java.util.*;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."
        };

        Set<String> seen = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) 
                sb.append(morse[c - 'a']);
            seen.add(sb.toString());
        }
        return seen.size();
    }

    public static void main(String[] args) {
        UniqueMorseCodeWords solver = new UniqueMorseCodeWords();
        String[] words1 = {"gin", "zen", "gig", "msg"};
        System.out.println(solver.uniqueMorseRepresentations(words1)); // 2

        String[] words2 = {"a"};
        System.out.println(solver.uniqueMorseRepresentations(words2)); // 1
    }
}
