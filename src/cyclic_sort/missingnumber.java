package cyclic_sort;

public class missingnumber {

        public int missingNumber(int[] nums) {
            int index = 0;
            while(index < nums.length){
                while(nums[index]!=nums.length &&nums[index] != nums[nums[index]]){
                    swap(nums,index,nums[index]);
                }
                index++;
            }
            for(int i = 0; i < nums.length;i++){
                if(nums[i] == nums.length){
                    return i;
                }
                else if(nums[i]!=nums[nums[i]]){
                    return i;
                }

            }
            return nums.length;

        }

        private void swap(int[] nums,int a,int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }



/**
 cyclic sort


 Input: nums = [3,0,1]
 Output: 2

 Input: nums = [9,6,4,2,3,5,7,0,1]
 |
 index = 1 , nums[1] = 6
 Output: 8

 [0,1,3]

 */

