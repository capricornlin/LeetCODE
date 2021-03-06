package cyclic_sort;

class FirstSmallestMissingPositive {

    public static int findNumber(int[] nums) {
        // TODO: Write your code here
        int index = 0;
        while(index < nums.length){
            if(nums[index] >0 && nums[index]<= nums.length && nums[index]!=nums[nums[index]-1]){
                swap(nums,index,nums[index]-1);
            }else{
                index++;
            }

        }
        for(int i = 0 ;i < nums.length;i++){
            if(nums[i] > nums.length || nums[i] <=0){
                return i+1;
            }else if(nums[i]!=i+1){
                return i;
            }
        }

        return -1;
    }

    private static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args){
        FirstSmallestMissingPositive f = new FirstSmallestMissingPositive();
        int[] array = new int[]{-3, 1, 5, 4, 2};
        System.out.println(f.findNumber(array));

    }


}


/**
 Input: [-3, 1, 5, 4, 2]
 Output: 3
 Explanation: The smallest missing positive number is '3'
 number:1~n
 unordered array find the missing positive number
 [-3,1,2,4,4]

 1.cyclic sort.
 2. skip the negative number and the number is bigger than nums.length.
 3. find the number is not the right position and is positive.




 */



