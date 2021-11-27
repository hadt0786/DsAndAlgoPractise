package Backtracking;
/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



        Example 1:

        Input: n = 3
        Output: ["((()))","(()())","(())()","()(())","()()()"]
        Example 2:

        Input: n = 1
        Output: ["()"]


        Constraints:

        1 <= n <= 8*/

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses_v22 {
    public List<String> generateParenthesis(int k) {
        // Write your solution here
        List<String> output = new ArrayList<>();
        char[] cur = new char[k*2];
        solve(cur, k, k, 0, output);
        return output;
    }

    private void solve(char[] cur, int left, int right, int index, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(new String(cur));
            return;
        }
        if (left > 0) {
            cur[index] = '(';
            solve(cur, left - 1, right, index + 1, result);
        }
        if (right > left) {
            cur[index] = ')';
            solve(cur, left, right - 1, index + 1, result);
        }
    }

}
