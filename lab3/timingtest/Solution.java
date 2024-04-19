package timingtest;
import java.util.ArrayList;
public class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        //最简单的情况
        char firstElem = s.charAt(0);
        if (firstElem == ')' || firstElem == '}' || firstElem == ']') {
            return false;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        //复杂情况
        ArrayList<Character> elems = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char elem = s.charAt(i);
            if (elem != ')' && elem != '}' && elem != ']') {
                elems.add(elem);
            } else {
                if(elems.size()==0&&i<s.length()-1){
                    return false;
                }
                if(elem == ')' && elems.get(elems.size() - 1) != '('){
                    return false;
                }
                if(elem == ']' && elems.get(elems.size() - 1) != '['){
                    return false;
                }
                if(elem == '}' && elems.get(elems.size() - 1) != '{'){
                    return false;
                }
                if (elem == ')' && elems.get(elems.size() - 1) == '(') {
                    elems.remove(elems.size() - 1);
                }
                if (elem == ']' && elems.get(elems.size() - 1) == '[') {
                    elems.remove(elems.size() - 1);
                }
                if (elem == '}' && elems.get(elems.size() - 1) == '{') {
                    elems.remove(elems.size() - 1);
                }
            }
        }
        return elems.isEmpty();
        }
    public static void main(String[] args) {
        Solution a=new Solution();
        System.out.println(a.isValid("(()"));
    }
}

