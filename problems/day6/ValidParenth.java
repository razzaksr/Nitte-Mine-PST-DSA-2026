package problems.day6;

import java.util.Stack;

public class ValidParenth {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        char[] chars = s.toCharArray();
        // type var:array
        for(char each : chars ){
            if(each=='{'||each=='('||each=='[') stk.push(each);
            else if(each=='}'||each==')'||each==']'){
                if(stk.isEmpty()) return false;
                char received = stk.pop();
                if(each=='}'&&received!='{'||each==']'&&received!='['||each==')'&&received!='(')
                    return false;
            }
        }
        if(stk.isEmpty()) return true;
        else return false;   
    }
    public static void main(String[] args) {
        ValidParenth obj = new ValidParenth();
        System.out.println(obj.isValid("()"));
        System.out.println(obj.isValid("()[]{}"));
        System.out.println(obj.isValid("(]"));
    }
}
