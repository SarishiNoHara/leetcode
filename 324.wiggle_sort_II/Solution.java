public class Solution {

	public void wiggleSort(int[] nums) {

		int[] newNums = new int[nums.length];

		int tail = nums.length;
		int half = (nums.length+1) >> 1 ; //half length 

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {

			if(i % 2 == 0){

				newNums[i] = nums[-- half];

			}else{

				newNums[i] = nums[-- tail];

			}

		}

		for(int i = 0; i<nums.length; i++) {

			nums[i] = newNums[i];
		}

	}

}
