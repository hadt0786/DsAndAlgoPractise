package subset_01;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllSubset_v2 {

   public static void main(String[] args) {
       int[] nums = {1, 2, 3};
       // Approach - 1
       // O(n*2^n)
       List<List<Integer>> output = subsetResult(nums);
       System.out.println(output.toString());

   }

   static List<List<Integer>> mainList;

   static List<List<Integer>> subsetResult(int [] nums) {
       mainList = new ArrayList<> ();
       List<Integer> list = new ArrayList<> () ;
       solve(list, nums, 0);
       return mainList;
   }

   static  void solve (List<Integer> list, int [] nums, int curr) {
       if(curr==nums.length) {
       mainList.add(new ArrayList(list));
       return;
       }
       List<Integer> list2 = new ArrayList<>(list);
       list.add(nums[curr]);
       solve(list2, nums, curr+1);
       solve(list, nums, curr+1);
   }

}
