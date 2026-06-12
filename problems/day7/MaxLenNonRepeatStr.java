package problems.day7;

import java.util.Hashtable;

public class MaxLenNonRepeatStr {
    // abcabcbb
    public static int findSubStr(String phrase){
        int size = phrase.length(), left = 0, right = 0, maxLen = 0;
        char key = '\0';
        Hashtable<Character,Integer> table = new Hashtable<>();
        while(right<size){
            key = phrase.charAt(right);
            if(table.containsKey(key))
                left = Math.max(left, table.get(key)+1);
            table.put(key,right);
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String phrase = "bbbbb";
        System.out.println(findSubStr(phrase));
    }
}
