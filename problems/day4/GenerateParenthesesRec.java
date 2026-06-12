package problems.day4;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesRec {
    public List<String> generateParenthesis(int n) {
        return generate(n);
    }
    private List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
            return result;
        }
        // Catalan recursion: split into left and right parts
        for (int c = 0; c < n; c++)
            for (String left : generate(c)) 
                for (String right : generate(n - 1 - c))
                    result.add("(" + left + ")" + right);
        return result;
    }

    public static void main(String[] args) {
        GenerateParenthesesRec gp = new GenerateParenthesesRec();
        System.out.println(gp.generateParenthesis(3));
        // Output: ["((()))","(()())","(())()","()(())","()()()"]
    }
}