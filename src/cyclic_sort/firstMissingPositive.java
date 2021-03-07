package cyclic_sort;

public class firstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int index = 0;
        if(nums == null || nums.length == 0){
            return 1;
        }
        while(index < nums.length){
            if(nums[index] >0 && nums[index] <= nums.length && nums[index] != nums[nums[index]-1]){
                swap(nums,index,nums[index]-1);
            }else{
                index++;
            }
        }
        for(int i =0; i< nums.length;i++){
            if(nums[i] <=0 || nums[i] > nums.length){
                return i+1;
            }else if(nums[i]!=i+1){
                return i+1;
            }
        }

        return nums.length+1;


    }
    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] =nums[b];
        nums[b] = temp;
    }
}


/**
 Input: nums = [1,2,0]
 Output: 3

 Input: nums = [3,4,-1,1]
 Output: 2

 Input: nums = [7,8,9,11,12]
 Output: 1

 */