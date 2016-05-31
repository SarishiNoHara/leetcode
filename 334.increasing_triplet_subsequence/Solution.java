public class Solution {
	public boolean increasingTriplet(int[] nums) {

		if(nums.length < 3)

			return false;

		int min1 = nums[0];

		int min2 = Integer.MAX_VALUE;

		for(int i = 0; i < nums.length; i++) {

			if(nums[i] > min2) {

				return true;

			}else if (nums[i] > min1 && nums[i] < min2) {

				min2 = nums[i];

			}else if (nums[i] < min1 ) {

				min1 = nums[i];
			}

		}

		return false;

	}

	public static void main(String[] args) {

		int[] nums  = {5,1,5,5,2,5,4};
		Solution a = new Solution();
		System.out.print(a.increasingTriplet(nums));
	}
}
