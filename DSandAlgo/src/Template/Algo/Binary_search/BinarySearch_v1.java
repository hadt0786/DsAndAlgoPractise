package Template.Algo.Binary_search;
// problem - Single Element in a Sorted Array

public class BinarySearch_v1 {

        // works only for Sorted Array


        public int singleNonDuplicate(int[] nums) {
            // initialize
            int low = 0,high = nums.length-1,mid = 0;

            // edge case check
            if(nums.length == 1)return nums[0];
            if(nums[low] != nums[low + 1])return nums[low];
            if(nums[high] != nums[high - 1])return nums[high];

            // Binary Search
            while(low <= high){
                mid = low + (high - low)/2;
                // found single element
                if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])return nums[mid];
                    //left side check
                else if((nums[mid] == nums[mid + 1] && mid % 2 == 0) || (
                        nums[mid] == nums[mid - 1] && mid % 2 != 0))low = mid + 1;
                    //right side check
                else high = mid - 1;
            }

            return -1;

    }
}
