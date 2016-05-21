public class Solution {

	public int integerBreak(int n) {

		int result;

		if(n <= 3){

			result = n - 1;

		}else{

			if(n % 3 == 0){

				result = (int)Math.pow(3, n/3);

			}else if(n % 3 == 1){

				result = 2 * 2 * (int)Math.pow(3, (n - 4)/3);

			}else{

				result = 2 * (int)Math.pow(3, (n - 2)/3);
			}
		}

		return result;

	}
}
