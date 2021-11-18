package subset_01;
import java.lang.Integer;
import java.lang.String;
import java.lang.System;
import java.util.*;

//https://leetcode.com/problems/subsets/
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

public class FindAllSubset {

	public static List<List<Integer>> subsetResult(int[] nums) {

		List<List<Integer>> output = new ArrayList<>();
		if (nums.length == 0) return output;

		subsethelper(0, nums, output, new ArrayList<>());

		return output;

	}

	public static void subsethelper(int index, int[] nums, List<List<Integer>> output, List<Integer> current_position) {
		output.add(new ArrayList<>(current_position));

		for(int i = index; i<nums.length; i++) {
			current_position.add(nums[i]);
			subsethelper(i+1, nums, output, current_position);
			current_position.remove(current_position.size()-1);
		}

	}

	public static void main(String[] args) { 
		int[] nums = {1,2,3};
		List<List<Integer>> output = subsetResult(nums);
		System.out.println(output.toString());
	}

}