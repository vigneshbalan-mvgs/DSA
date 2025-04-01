class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    int product = 1;
    
    for (int i = 0; i < nums.length; i++) {
      result[i] = product;
      product *= nums[i];
    }
    
    product = 1;
    
    for (int i = nums.length - 1; i >= 0; i--) {
      result[i] *= product;
      product *= nums[i];
    }
    
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    Solution solution = new Solution();
    int[] result = solution.productExceptSelf(nums);
    
    for (int num : result) {
      System.out.println(num + " ");
    }
  }
}
