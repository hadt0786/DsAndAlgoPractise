package subset_01;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/subsets/
// https://www.youtube.com/watch?v=fqrOsZdKegQ&list=PLzffTJx5aHaSJ4XaG55cI3Z0VrNOyLWpH&index=2
//
//		Given an integer array nums of unique elements, return all possible subsets (the power set).
//
//		The solution set must not contain duplicate subsets. Return the solution in any order.
//
//
//
//		Example 1:
//
//		Input: nums = [1,2,3]
//		Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//		Example 2:
//
//		Input: nums = [0]
//		Output: [[],[0]]
//
//
//		Constraints:
//
//		1 <= nums.length <= 10
//		-10 <= nums[i] <= 10
//		All the numbers of nums are unique.

public class FindAllSubset_v1 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        // Approach - 1
        // O(n*2^n)
        List<List<Integer>> output = subsetResult(nums);
        System.out.println(output.toString());

        //Approach - 2
        // O(2^n)
        List<List<Integer>> output2 = subsets(nums);
        System.out.println(output2.toString());
    }

    public static List<List<Integer>> subsetResult(int[] nums) {
        List<List<Integer>> subset = new ArrayList();
        if (nums.length == 0) return subset;
        //Arrays.sort(nums); // optional
        subsetHelper(0, subset, new ArrayList(), nums);
        return subset;
    }

    public static void subsetHelper(int index, List<List<Integer>> subset, List<Integer> current_position, int[] nums) {

        subset.add(new ArrayList(current_position));
        for (int i = index; i < nums.length; i++) {
            current_position.add(nums[i]);
            subsetHelper(i + 1, subset, current_position, nums);
            current_position.remove(current_position.size() - 1);
        }

    }

    static List<List<Integer>> lists;
    public static List<List<Integer>> subsets(int[] nums) {
        lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(list,nums,0);

        return lists;
    }

     static void solve(List<Integer> list, int[] nums, int curr)
    {

        if(curr == nums.length)
        {

            lists.add(new ArrayList(list));
            //System.out.println(true + " --> "+ lists.toString());
            return;
        }

        List<Integer> list2 = new ArrayList(list);
        list.add(nums[curr]);
        //System.out.println("nums--" +nums[curr] + " list 1--> " + list.toString() + " //list 2--> " + list2.toString() +" main --> " + lists.toString());
        solve(list2,nums,curr+1);
        solve(list,nums,curr+1);

    }

}