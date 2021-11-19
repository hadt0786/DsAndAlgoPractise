package subset_01;

/* https://leetcode.com/problems/combinations/
 77. Combinations
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

        You may return the answer in any order.



        Example 1:

        Input: n = 4, k = 2
        Output:
        [
        [2,4],
        [3,4],
        [2,3],
        [1,2],
        [1,3],
        [1,4],
        ]
        Example 2:

        Input: n = 1, k = 1
        Output: [[1]]


        Constraints:

        1 <= n <= 20
        1 <= k <= n*/


import java.util.ArrayList;
import java.util.List;

public class Combination_v2 {


    public static void main(String[] args) {


    }

    // II). Recursion -- C(n,k)=C(n-1,k-1)+C(n-1,k)
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n - 1, k));
        return result;
    }

}
