public class Solution {

	public boolean isValidSerialization(String preorder) {

		int nullNodes = 0;

		int nodes = 0;

		String[] array = preorder.split(",");

		for(int i = array.length - 1; i >= 0; i --) {

			if(array[i].equals("#")) {

				nullNodes ++;

			} else {

				nodes ++;

			}

			if(nullNodes - nodes < 1) {

				return false;
			}

		}

		return nullNodes - nodes == 1;
	}
