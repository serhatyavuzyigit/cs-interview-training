class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int answer = target;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            int l = i+1;
            int r = nums.length-1;
            while(l < r) {
                int _sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(target-_sum) < diff) {
                    diff = Math.abs(target-_sum);
                    if(target-_sum <0)
                        answer = target + diff;
                    else 
                        answer = target - diff;
                }       
                if(_sum > target)
                    r--;
                else 
                    l++;
            }
        }

        return answer;
    }
}