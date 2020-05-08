class HouseRobber {
    public int rob(int[] nums) {
        
        int size = nums.length;
        
        if(size == 0){
            return 0;
        } else if(size == 1){
            return nums[0];
        } else if(size == 2){
            return Math.max(nums[0], nums[1]);
        } else{
            
            int [] dp_arr = new int [size]; 
            
            dp_arr[0] = nums[0];
            dp_arr[1] = Math.max(nums[0], nums[1]);
                                 
            for(int i=2; i<size; i++){
                dp_arr[i] = Math.max(dp_arr[i-2] + nums[i], dp_arr[i-1]);
            }
            return dp_arr[size-1];
        }
        
    }
}